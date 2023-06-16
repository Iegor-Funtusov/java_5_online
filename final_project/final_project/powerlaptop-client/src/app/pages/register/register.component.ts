import {Component, OnInit} from '@angular/core';
import {FormBuilder, ReactiveFormsModule, Validators} from "@angular/forms";
import {map, Observable} from "rxjs";
import {CommonModule} from "@angular/common";
import {SessionService} from "../../services/session.service";
import {RegisterService} from "../../services/register.service";
import {Route, Router} from "@angular/router";

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss'],
  imports: [
    ReactiveFormsModule,
    CommonModule
  ],
  standalone: true
})
export class RegisterComponent implements OnInit{

  form = this._fb.group({
    username: ['', [Validators.required, Validators.email]],
    password: ['', [Validators.required, Validators.min(8)]],
  })

  isSubmit: Observable<boolean> = this.form.statusChanges.pipe(
    map(status => status === 'VALID')
  );

  constructor(
    private _fb: FormBuilder,
    private _registerService: RegisterService,
    private _sessionService: SessionService, private _router: Router) {
  }

  ngOnInit(): void { }

  register(): void {
    let value = this.form.value;
    const username: string = value.username as string;
    const password: string = value.password as string;
    this._registerService.register(username, password).subscribe(res => {
      this._sessionService.addToStorage("token", JSON.stringify(res));
      this._router.navigateByUrl('/plp');
    });
  }
}
