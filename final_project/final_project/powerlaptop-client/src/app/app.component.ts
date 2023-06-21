import { Component } from '@angular/core';
import { RouterOutlet } from "@angular/router";
import { AppSearchComponent } from "./components/app-search/app-search.component";

@Component({
  selector: 'app-root',
  standalone: true,
  templateUrl: './app.component.html',
  imports: [
    RouterOutlet,
    AppSearchComponent
  ],
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'powerlaptop-client';
}
