# FindAnyBook
Android Project

The application will let the user see a TextView with the instruction to enter the name of the book. User will have to enter whole book name, or some part of book name such as first word, or some text from book in the EditText and tap the “Search the books”  button. Once user taps this button, the keyboard will disappear and the progress dialog will show message “Loading”.

The button will execute a Retrofit that queries the Google Books API to find multiple results of small images, different authors and different titles of the books displayed in a RecyclerView card-based layout. The book search results will be showed under the “Search the books” button on the same MainActivity.

When user clicks on one of the result items in the RecyclerView, it will open a SecondActivity titled same as the chosen book and show more of the data such as larger book image, categories, description, publisher, published date, page count, ISBN_10 and ISBN_13 as TextViews, which user can scroll down in ScrollView.

Updated the dark version of application's theme.

  End point: 
  GET https://www.googleapis.com/books/v1/volumes

