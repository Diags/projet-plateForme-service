import {AfterViewInit, Component, EventEmitter, Input, Output, ViewChild} from '@angular/core';
import {jqxSchedulerComponent} from 'jqwidgets-ng/jqxscheduler';
import {CatalogueService} from "../catalogue.service";

@Component({
  selector: 'app-calendar',
  templateUrl: './calendar.component.html',
  styleUrls: ['./calendar.component.css']
})
export class CalendarComponent implements AfterViewInit {
  events;
  appointments;
  @Output() appointmentChanges: EventEmitter<String> = new EventEmitter<String>();
  @Input() userId;

  public constructor(private catelogService: CatalogueService) {

  }

  @ViewChild('scheduler') myScheduler: jqxSchedulerComponent;

  ngAfterViewInit() {
    this.generateAppointments(this.userId);
        // //console.log(  this.myScheduler.getSelection(),"selected");
    console.log(this.myScheduler.changedAppointments(), "getAppointgetDataAppointmentsments");
    // console.log(  this.myScheduler.onAppointmentChange,"getAppointgetDataAppointmentsments");

  }

  checkconnection() {
    if (this.catelogService.isAuthentificated()) {
      return true;
    } else {
      this.myScheduler.setAppointmentProperty(this.events, 'readOnly', false);

      return false;
    }

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
        console.log(this.events[i], "evenenenents");
        this.myScheduler.editDialog(this.checkconnection())
        this.myScheduler.setAppointmentProperty(this.events[i].id, 'draggable', false);
        this.myScheduler.setAppointmentProperty(this.events[i].id, 'readOnly', false);
        this.myScheduler.setAppointmentProperty(this.events[i].id, 'resizable', false);


      }
    }, error => {
      console.log(error, "errrroorr")
    });
  };

  date: any = new jqx.date();
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
