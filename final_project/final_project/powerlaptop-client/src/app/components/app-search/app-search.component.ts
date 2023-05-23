import {Component, OnInit} from '@angular/core';
import {ProductSearchService} from "../../services/product-search.service";
import {FormControl, FormGroup, ReactiveFormsModule} from "@angular/forms";
import {BehaviorSubject, Observable, take} from "rxjs";
import {ProductInfoModel} from "../../models/product-info.model";
import {AsyncPipe, NgForOf, NgIf} from "@angular/common";

@Component({
  selector: 'app-search',
  standalone: true,
  templateUrl: './app-search.component.html',
  imports: [
    ReactiveFormsModule,
    AsyncPipe,
    NgForOf,
    NgIf
  ],
  styleUrls: ['./app-search.component.scss']
})
export class AppSearchComponent implements OnInit {

  private productsSub$ = new BehaviorSubject<ProductInfoModel[]>([]);
  products$: Observable<ProductInfoModel[]> = this.productsSub$.asObservable();

  queryForm : FormGroup = new FormGroup({
    "query": new FormControl()
  });

  constructor(private _productSearchService: ProductSearchService) {
  }

  ngOnInit(): void {
    this.queryForm.valueChanges
      .subscribe(value => {
        this._productSearchService
          .searchProduct(value.query)
          .pipe(
            take(1),
          )
          .subscribe(res => {
            let productInfoModelList: ProductInfoModel[] = res as ProductInfoModel[];
            this.productsSub$.next(productInfoModelList);
          });
      });
  }
}
