import {AfterViewInit, Component, Input, ViewChild} from '@angular/core';
import {jqxSchedulerComponent} from 'jqwidgets-ng/jqxscheduler';
import {CatalogueService} from "../catalogue.service";

@Component({
  selector: 'app-calendar',
  templateUrl: './calendar.component.html',
  styleUrls: ['./calendar.component.css']
})
export class CalendarComponent implements AfterViewInit {
  events;
  @Input() userId;

  public constructor(private catelogService: CatalogueService) {

  }

  @ViewChild('scheduler') myScheduler: jqxSchedulerComponent;

  ngAfterViewInit() {
    this.generateAppointments(this.userId);
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
    this.catelogService.getEvents(userId).subscribe(resp => {
      this.events = resp;
      console.log(resp, "evenenenents");
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
storeAppointemnInBd(eventId, userId){
  this.catelogService.storeUserEvents(eventId,userId ).subscribe(resp => {
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
      console.log(appointment, "appointment tetstete ***");

      this.storeAppointemnInBd(event.args.appointment.id,this.userId);
    } else {
      alert("No subject in appointment");
      this.myScheduler.setAppointmentProperty(event.args.appointment.id, 'readOnly', false);

    }


    console.log(appointment, "appointment Add ***");
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
      dataType: 'array',
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
      localData: this.events
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
