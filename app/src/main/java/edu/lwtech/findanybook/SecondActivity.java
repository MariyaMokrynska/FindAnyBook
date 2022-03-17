/**
 * Mariya Mokrynska
 */
package edu.lwtech.findanybook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent = getIntent();

        TextView titleTextView = findViewById(R.id.title_textview);
        titleTextView.setText(intent.getStringExtra(CustomAdapter.TITLE_KEY));

        SecondActivity.this.setTitle(intent.getStringExtra(CustomAdapter.TITLE_KEY));

        TextView authorsTextView = findViewById(R.id.authors_textview);
        authorsTextView.setText(intent.getStringExtra(CustomAdapter.AUTHOR_KEY));

        TextView categoriesTextView = findViewById(R.id.categories_textview);
        categoriesTextView.setText(intent.getStringExtra(CustomAdapter.CATEGORIES_KEY));

        TextView descriptionTextView = findViewById(R.id.description_textview);
        descriptionTextView.setText(intent.getStringExtra(CustomAdapter.DESCRIPTION_KEY));

        TextView publisherTextView = findViewById(R.id.publisher_textview);
        publisherTextView.setText(intent.getStringExtra(CustomAdapter.PUBLISHER_KEY));

        TextView publishedDateTextView = findViewById(R.id.published_date_textview);
        publishedDateTextView.setText(intent.getStringExtra(CustomAdapter.PUBLISHED_DATE_KEY));

        TextView pageCountTextView = findViewById(R.id.page_count_textview);
        pageCountTextView.setText(intent.getStringExtra(CustomAdapter.PAGE_COUNT_KEY));

        TextView isbn10TextView = findViewById(R.id.isbn_10_textview);
        isbn10TextView.setText(intent.getStringExtra(CustomAdapter.ISBN_10_KEY));

        TextView isbn13TextView = findViewById(R.id.isbn_13_textview);
        isbn13TextView.setText(intent.getStringExtra(CustomAdapter.ISBN_13_KEY));

        ImageView bigImageView = findViewById(R.id.bigImageView);
        String imageUrl = intent.getStringExtra(CustomAdapter.BIG_IMAGE_KEY);

        if (imageUrl.length() != 0) {
            Picasso.Builder builder = new Picasso.Builder(this.getApplicationContext());
            builder.listener(new Picasso.Listener() {
                @Override
                public void onImageLoadFailed(Picasso picasso, Uri uri, Exception exception) {
                    Log.e("Err", uri.toString() + exception.getMessage());
                }
            });
            builder.build().load(imageUrl)
                    .fit().centerInside()
                    .placeholder(R.drawable.ic_launcher_background)
                    .error(R.drawable.ic_launcher_foreground)
                    .into(bigImageView);

        } else {
            bigImageView.setImageResource(R.drawable.ic_launcher_foreground);
        }


    }
}