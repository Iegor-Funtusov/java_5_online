import {Component, OnInit} from '@angular/core';
import {PlpService} from "../../services/plp.service";
import {ProductPlpModel} from "../../models/product-plp.model";
import {AsyncPipe, JsonPipe, NgForOf, NgIf} from "@angular/common";
import {Observable} from "rxjs";
import {Router} from "@angular/router";

@Component({
  selector: 'app-plp',
  standalone: true,
  templateUrl: './plp.component.html',
  imports: [
    JsonPipe,
    AsyncPipe,
    NgIf,
    NgForOf
  ],
  styleUrls: ['./plp.component.scss']
})
export class PlpComponent implements OnInit {

  plpList$: Observable<ProductPlpModel[]> = this._plpService.loadProducts() as Observable<ProductPlpModel[]>;

  constructor(private _plpService: PlpService, private _router: Router) { }

  ngOnInit(): void { }

  redirectToPdp(productId: number): void {
    this._router.navigateByUrl('/pdp/' + productId);
  }
}
