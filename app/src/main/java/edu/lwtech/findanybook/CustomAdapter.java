/**
 * Mariya Mokrynska
 */
package edu.lwtech.findanybook;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {
    private List<Book> bookList;
    private Context context;
    LayoutInflater layoutInflater;

    public final static String BIG_IMAGE_KEY = "big image";
    public final static String TITLE_KEY = "title";
    public final static String AUTHOR_KEY = "author";
    public final static String CATEGORIES_KEY = "categories";
    public final static String DESCRIPTION_KEY = "description";
    public final static String PUBLISHER_KEY = "publisher";
    public final static String PUBLISHED_DATE_KEY = "published date";
    public final static String PAGE_COUNT_KEY = "page count";
    public final static String ISBN_10_KEY = "isbn 10";
    public final static String ISBN_13_KEY = "isbn 13";

    public CustomAdapter(Context context, List<Book> bookList) {
        this.context = context;
        this.bookList = bookList;
        layoutInflater = LayoutInflater.from(context);
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {

        public final View mView;
        TextView bookTitle;
        TextView bookAuthor;
        TextView imageLink;
        ImageView coverImage;

        CustomViewHolder(View itemView) {
            super(itemView);
            mView = itemView;

            bookTitle = mView.findViewById(R.id.bookTitle);
            bookAuthor = mView.findViewById(R.id.bookAuthor);
            coverImage = mView.findViewById(R.id.littleImageView);
        }
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.recycler_view_item, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        VolumeInfo book = bookList.get(position).getVolumeInfo();
        holder.bookTitle.setText(book.getTitle());
        holder.bookAuthor.setText(book.getAuthorsText());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, SecondActivity.class);
                if (book.getImages() != null && book.getImages().getBigImage() != null) {
                    intent.putExtra(BIG_IMAGE_KEY, book.getImages().getBigImage());
                } else {
                    intent.putExtra(BIG_IMAGE_KEY, "");
                }
                intent.putExtra(TITLE_KEY, book.getTitle());
                intent.putExtra(AUTHOR_KEY, book.getAuthorsText());
                intent.putExtra(CATEGORIES_KEY, book.getCategoriesText());
                intent.putExtra(DESCRIPTION_KEY, book.getDescription());
                intent.putExtra(PUBLISHER_KEY, book.getPublisher());
                intent.putExtra(PUBLISHED_DATE_KEY, book.getPublishedDate());
                intent.putExtra(PAGE_COUNT_KEY, book.getPageCount());
                intent.putExtra(ISBN_10_KEY, book.getISBN10());
                intent.putExtra(ISBN_13_KEY, book.getISBN13());
                context.startActivity(intent);
            }
        });
        if (book.getImages() != null && book.getImages().getSmallImage() != null) {
            Picasso.Builder builder = new Picasso.Builder(context.getApplicationContext());
            builder.listener(new Picasso.Listener() {
                @Override
                public void onImageLoadFailed(Picasso picasso, Uri uri, Exception exception) {
                    Log.e("Err", uri.toString() + exception.getMessage());
                }
            });
            builder.build().load(book.getImages().getSmallImage())
                    .fit().centerInside()
                    .placeholder(R.drawable.ic_launcher_background)
                    .error(R.drawable.ic_launcher_foreground)
                    .into(holder.coverImage);
        } else {
            holder.coverImage.setImageResource(R.drawable.ic_launcher_foreground);
        }
    }

    @Override
    public int getItemCount() {
        return bookList.size();
    }
}
