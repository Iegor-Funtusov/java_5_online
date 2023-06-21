import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { map, Observable } from "rxjs";

import { AuthData } from "../models/auth.data";
import { appSettings } from "../app.const";

@Injectable({
  providedIn: 'root'
})
export class RegisterService {

  constructor(private _http: HttpClient ) {
  }

  register(username: string, password: string): Observable<any> {
    const register = {
      username: username,
      password: password,
      roleType: 'PERSONAL'
    };
    return this._http.post(appSettings.apiOpen + '/auth/register', register)
      .pipe(
        map(res => {
          return  res as AuthData;
        })
      );
  }
}
