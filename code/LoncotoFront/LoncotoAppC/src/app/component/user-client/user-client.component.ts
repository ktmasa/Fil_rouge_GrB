import { Component, OnInit, Input } from '@angular/core';
import { Client } from '../../metier/client';
import { ClientRepositoryService } from '../../service/client-repository.service';
import { Observable } from '../../../../node_modules/rxjs';

@Component({
  selector: 'app-user-client',
  templateUrl: './user-client.component.html',
  styleUrls: ['./user-client.component.css']
})
export class UserClientComponent implements OnInit {

  @Input() public clientId: number;
  public currentClient: Client;
  public client: Observable<Client>;


  constructor(private clientRepository: ClientRepositoryService) { }

  ngOnInit() {
    this.client = this.clientRepository.getClientAsObservable();
  }

  public ngOnChanges(changes: any) {
    if (this.currentClient.id > 0) {
      this.clientRepository.findById(this.clientId).subscribe(c => {
        this.currentClient = c;
      });

    }

  }
}