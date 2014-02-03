package coursera.activitylab;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.Button;
import android.widget.TextView;

public class ActivityTwo extends ActionBarActivity {
    private static final String RESTART_KEY = "restart";
    private static final String RESUME_KEY = "resume";
    private static final String START_KEY = "start";
    private static final String CREATE_KEY = "create";

    // String for LogCat documentation
    private final static String TAG = "Lab-ActivityTwo";

    // Lifecycle counters

    // TODO:
    // Create counter variables for onCreate(), onRestart(), onStart() and
    // onResume(), called mCreate, etc.
    // You will need to increment these variables' values when their
    // corresponding lifecycle methods get called
    int mCreate = 0;
    int mResume = 0;
    int mStart = 0;
    int mRestart = 0;


    // TODO: Create variables for each of the TextViews, called
    // mTvCreate, etc.
    TextView mTvCreate ;
    TextView mTvStart;
    TextView mTvResume;
    TextView mTvRestart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_two);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }

        // TODO: Assign the appropriate TextViews to the TextView variables
        // Hint: Access the TextView by calling Activity's findViewById()
        // textView1 = (TextView) findViewById(R.id.textView1);
        mTvCreate = (TextView) findViewById(R.id.mTvCreate);
        mTvStart = (TextView) findViewById(R.id.mTvStart);
        mTvRestart = (TextView) findViewById(R.id.mTvRestart);
        mTvResume = (TextView) findViewById(R.id.mTvResume);

        Button closeButton = (Button) findViewById(R.id.bClose);
        closeButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                // TODO:
                // This function closes Activity Two
                // Hint: use Context's finish() method

                finish();

            }
        });

        // Check for previously saved state
        if (savedInstanceState != null) {

            // TODO:
            // Restore value of counters from saved state
            // Only need 4 lines of code, one for every count variable
            mRestart = savedInstanceState.getInt(RESTART_KEY);
            mResume = savedInstanceState.getInt(RESUME_KEY);
            mStart = savedInstanceState.getInt(START_KEY);
            mCreate = savedInstanceState.getInt(CREATE_KEY);
        }

        // TODO: Emit LogCat message
        Log.i(TAG, "emit logcat");


        // TODO:
        // Update the appropriate count variable
        // Update the user interface via the displayCounts() method
        mCreate++;
        displayCounts();


    }

    // Lifecycle callback methods overrides

    @Override
    public void onStart() {
        super.onStart();

        // TODO: Emit LogCat message
        Log.i(TAG, "in start");

        // TODO:
        // Update the appropriate count variable
        // Update the user interface
        mStart++;
        displayCounts();


    }

    @Override
    public void onResume() {
        super.onResume();

        // TODO: Emit LogCat message
        Log.i(TAG, "in resume");

        // TODO:
        // Update the appropriate count variable
        // Update the user interface
        mResume++;
        displayCounts();
    }

    @Override
    public void onPause() {
        super.onPause();

        // TODO: Emit LogCat message
        Log.i(TAG, "in pause");


    }

    @Override
    public void onStop() {
        super.onStop();

        // TODO: Emit LogCat message
        Log.i(TAG, "in stop");


    }

    @Override
    public void onRestart() {
        super.onRestart();

        // TODO: Emit LogCat message

        Log.i(TAG, "in restart");
        // TODO:
        // Update the appropriate count variable
        // Update the user interface
        mRestart++;
        displayCounts();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        // TODO: Emit LogCat message
        Log.i(TAG, "in destroy");
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {

        // TODO:
        // Save counter state information with a collection of key-value pairs
        // 4 lines of code, one for every count variable

        savedInstanceState.putInt(CREATE_KEY, mCreate);
        savedInstanceState.putInt(RESTART_KEY, mRestart);
        savedInstanceState.putInt(RESUME_KEY, mResume);
        savedInstanceState.putInt(START_KEY, mStart);
    }

    // Updates the displayed counters
    public void displayCounts() {

        mTvCreate.setText("onCreate() calls: " + mCreate);
        mTvStart.setText("onStart() calls: " + mStart);
        mTvResume.setText("onResume() calls: " + mResume);
        mTvRestart.setText("onRestart() calls: " + mRestart);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_two, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case R.id.action_settings:
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main_two, container, false);
            return rootView;
        }
    }

}
