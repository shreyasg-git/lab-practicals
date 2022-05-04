import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  title: String = 'StarterApp';
  authorName: String = 'Shreyas Balasaheb Gangurde';
  clickCount: number = 0;

  incrementCount() {
    this.clickCount += 1;
    console.log('HIIIIIIII');
  }

  decrementCount() {
    this.clickCount -= 1;
  }
}
