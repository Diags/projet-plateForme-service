import {AfterViewInit, Component, Input, OnInit, ViewChild} from '@angular/core';
import {jqxSchedulerComponent} from 'jqwidgets-ng/jqxscheduler';
import {CatalogueService} from "../catalogue.service";

@Component({
  selector: 'app-calendar',
  templateUrl: './calendar.component.html',
  styleUrls: ['./calendar.component.css']
})
export class CalendarComponent implements AfterViewInit, OnInit {
  events;
  @Input() userId;
  flag:boolean = true;

  public constructor(private catelogService: CatalogueService) {

  }

  @ViewChild('scheduler') myScheduler: jqxSchedulerComponent;

  ngAfterViewInit() {
    this.generateAppointments(this.userId);
   // this.myScheduler.beginAppointmentsUpdate();
    console.log(this.source);
   // this.flag = true;
  }

  ngOnInit(): void {
  }

  getWidth(): any {
    if (document.body.offsetWidth < 800) {
      return '90%';
    }

    return 800;
  }

  getAllEventsInbBD() {

  }

  generateAppointments(userId) {
    this.catelogService.getEventsbyId(userId).subscribe(resp => {
      this.flag = false;
      this.events = resp;
      console.log(resp, "evenenenents");
      this.source.localdata = this.events;
      this.source.localData = this.events;
      for (let i = 0; i < this.events.length; i++) {

        this.myScheduler.addAppointment(this.events[i]);
        // this.myScheduler.editDialog(this.checkconnection())
        // this.myScheduler.setAppointmentProperty(this.events[i].id, 'draggable', true);
        // this.myScheduler.setAppointmentProperty(this.events[i].id, 'readOnly', true);
        // this.myScheduler.setAppointmentProperty(this.events[i].id, 'resizable', false);
        // this.myScheduler.setAppointmentProperty(this.events[i].id, 'disabled', true);

      }

    }, error => {
      console.log(error, "errrroorr")
    });
  };

  date: any = new jqx.date();

  ready = (): void => {
    this.myScheduler.scrollTop(700);
  }

  mySchedulerOnAppointmentDelete(event: any): void {
    let appointment = event.args.appointment;
    console.log(appointment, "appointment Delete ***");

  };

  storeAppointemnInBd(event, userId) {
    let appoitement = {
      id: parseInt(event.id),
      description: event.originalData.description,
      location: event.originalData.location,
      subject: event.originalData.subject,
      calendar: event.originalData.calendar,
      startDate: new Date(event.originalData.start),
      endDate: new Date(event.originalData.end)
    };

    this.catelogService.storeUserEventsbyId(appoitement, userId).subscribe(resp => {
      this.events = resp;
    })

  }

  mySchedulerOnAppointmentAdd(event: any): void {
    let appointment = event.args.appointment;
    if (event.args.appointment.subject.length > 0) {
      this.myScheduler.setAppointmentProperty(event.args.appointment.id, 'readOnly', true);
      this.myScheduler.setAppointmentProperty(event.args.appointment.id, 'resizable', false);
      this.myScheduler.setAppointmentProperty(event.args.appointment.id, 'draggable', false);
      this.myScheduler.setAppointmentProperty(event.args.appointment.id, 'disabled', true);
      // this.storeAppointemnInBd(event.args.appointment, this.userId);

    } else {
      alert("No subject in appointment");
      this.myScheduler.setAppointmentProperty(event.args.appointment.id, 'readOnly', false);
    }
    if (this.flag) {
      this.storeAppointemnInBd(event.args.appointment, this.userId);
      console.log(event.args, "appointment tititit fin addd ***");
    }


  };

  mySchedulerOnAppointmentDoubleClick(event: any): void {
    //
    // let appointment = event.args.appointment;
    // console.log(appointment, "appointment DoubleClick  ***");
  };

  mySchedulerOnAppointmentChange(event: any): void {

    let appointment = event.args.appointment;
    console.log(appointment, "appointment Change ***");
  };


  mySchedulerOnCellDoubleClick(event: any): void {
    // // if (this.catelogService.isAuthentificated()) {
    // //   let appointment = event.args.appointment;
    // //   console.log(appointment, "appointment DoubleClick ***");
    // // } else {
    // //   this.myScheduler.setAppointmentProperty(event.args.appointment.id, 'readOnly', true);
    // //   this.myScheduler.setAppointmentProperty(event.args.appointment.id, 'resizable', false);
    // //   this.myScheduler.setAppointmentProperty(event.args.appointment.id, 'draggable', false);
    // // }
    //
    //
    // let cell = event.args.cell;
    // console.log(cell, "celle clicked ***");
  };

  mySchedulerOnDialogCreate(event: any): void {

  }
  mySchedulerOnEditDialogClose(event: any): void {

  }
  source: any =
    {
      dataType: 'json',
      dataFields: [
        {name: 'id', type: 'string'},
        {name: 'description', type: 'string'},
        {name: 'location', type: 'string'},
        {name: 'subject', type: 'string'},
        {name: 'calendar', type: 'string'},
        {name: 'start', type: 'date'},
        {name: 'end', type: 'date'}
      ],
      id: 'id',
      localdata: null
    };
  dataAdapter: any = new jqx.dataAdapter(this.source);
  resources: any =
    {
      colorScheme: 'scheme05',
      dataField: 'calendar',
      source: new jqx.dataAdapter(this.source)
    };
  appointmentDataFields: any =
    {
      from: 'start',
      to: 'end',
      id: 'id',
      description: 'description',
      location: 'place',
      subject: 'subject',
      resourceId: 'calendar'
    };
  views: string[] | any[] =
    [
      'dayView',
      'weekView',
      'monthView',
      'agendaView'
    ];
}
