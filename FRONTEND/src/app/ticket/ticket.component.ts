import { Component, OnInit } from '@angular/core';
import {Ticket} from '../../models/ticket.model.client';
import {Location} from '@angular/common';
import {TicketServiceClient} from '../../services/ticket.service.client';
import {ActivatedRoute} from '@angular/router';



@Component({
  selector: 'app-ticket',
  templateUrl: './ticket.component.html',
  styleUrls: ['./ticket.component.css']
})
export class TicketComponent implements OnInit {

  ticket: Ticket = new Ticket();
  submitted = false;
  message: string;

  constructor(
    private ticketService: TicketServiceClient,
    private location: Location,
    private routing: ActivatedRoute
  ) { }


  ngOnInit() {
    this.routing.params.subscribe(params => this.ticket.customer_id = params['customerid2']);
  }

  newTicket(): void {
    this.submitted = false;
    this.ticket = new Ticket();
  }

  save() {
    this.ticketService.addTicket(this.ticket)
      .subscribe(data => console.log(data), error => console.log(error));
    this.ticket = new Ticket();
  }

  onSubmit() {
    this.submitted = true;
    this.save();
  }

  goBack(): void {
    this.location.back();
  }

}
