import { HttpInterceptorFn } from "@angular/common/http";
import { tap } from "rxjs";
import { appSettings } from "../app.const";

export const authInterceptor: HttpInterceptorFn = (req, next) => {

    if (req.url.startsWith(appSettings.apiPrivate)) {
      const token = localStorage.getItem('token')
        const headers = req.headers.set('Authorization', 'Bearer ' + token);
        req = req.clone({headers});
    }

    return next(req).pipe(
        tap(resp => console.log('response', resp))
    );
}
