import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {map, Observable} from "rxjs";
import {appSettings} from "../app.const";
import {DataContainer} from "../models/data.container";

@Injectable({
  providedIn: 'root'
})
export class CartService {

  constructor(private _http: HttpClient) {
  }

  loadCart(): Observable<string> {
    return this._http.get(appSettings.apiPrivatePersonal + '/cart')
      .pipe(
        map(res => {
          const data: DataContainer = res as DataContainer;
          return data.data;
        })
      );
  }
}
