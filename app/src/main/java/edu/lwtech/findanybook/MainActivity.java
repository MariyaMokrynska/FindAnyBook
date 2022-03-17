/**
 * Mariya Mokrynska
 */
package edu.lwtech.findanybook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private static String queryString = "";
    private static SearchResult lastResult = null;
    private EditText mBookInput;
    private CustomAdapter adapter;
    private RecyclerView recyclerView;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBookInput = (EditText) findViewById(R.id.bookInput);
        mBookInput.setText(queryString);
        recyclerView = findViewById(R.id.bookListView);
        if (lastResult != null) {
            generateDataList(lastResult);
        }
    }

    public void searchBooks(View view) {
        try {
            // Get the search string from the input field.
            queryString = mBookInput.getText().toString();

            InputMethodManager inputManager = (InputMethodManager)
                    getSystemService(Context.INPUT_METHOD_SERVICE);

            if (inputManager != null) {
                inputManager.hideSoftInputFromWindow(view.getWindowToken(),
                        InputMethodManager.HIDE_NOT_ALWAYS);
            }

            progressDialog = new ProgressDialog(MainActivity.this);
            progressDialog.setMessage("Loading....");
            progressDialog.show();
            /*Create handle for the RetrofitInstance interface*/
            GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
            Call<SearchResult> call = service.getSearchResult(queryString, 40);
            call.enqueue(new Callback<SearchResult>() {
                @Override
                public void onResponse(Call<SearchResult> call, Response<SearchResult> response) {
                    progressDialog.dismiss();
                    lastResult = response.body();
                    generateDataList(lastResult);
                }

                @Override
                public void onFailure(Call<SearchResult> call, Throwable t) {
                    progressDialog.dismiss();
                    Toast.makeText(MainActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
                }
            });
        } catch (Exception e) {
            Log.e("log", e.getMessage());
            progressDialog.dismiss();
        }
    }

    /*Method to generate List of data using RecyclerView with custom adapter*/
    private void generateDataList(SearchResult searchResults) {
        adapter = new CustomAdapter(this, searchResults.getBooks());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
}