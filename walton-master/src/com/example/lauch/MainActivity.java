package com.example.lauch;

import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
import HTTPClient.AsyncHttpPostClient;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity 
{

	private Handler handler;
	String url;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		ArrayList<NewsItem> image_details = getListData();
		final ListView lv1 = (ListView) findViewById(R.id.custom_list);

		lv1.setAdapter(new CustomListAdapter(this, image_details));
		lv1.setOnItemClickListener(new OnItemClickListener() 
		{
			@Override
			public void onItemClick(AdapterView<?> a, View v, int position, long id) 
			{
				Object o = lv1.getItemAtPosition(position);
				NewsItem newsData = (NewsItem) o;
				Toast.makeText(MainActivity.this, "Selected :" + " " + newsData+ " assadas : "
						+newsData.getShortName(), Toast.LENGTH_SHORT).show();
				url = newsData.getUrl();
				HTTPClient();
				
			}
		});
	}

	private ArrayList<NewsItem> getListData()
	{
		ArrayList<NewsItem> results = new ArrayList<NewsItem>();
		NewsItem newsData = new NewsItem();
		newsData.setHeadline("Dance of Democracy");
		newsData.setReporterName("Pankaj Gupta");
		newsData.setDate("May 26, 2013, 13:35");
		newsData.setName("aaaaaaaaaaaaaaaaaaaa");
		newsData.setUrl("http://petarosoft.com/android/samplejson");
		results.add(newsData);

		newsData = new NewsItem();
		newsData.setHeadline("Major Naxal attacks in the past");
		newsData.setReporterName("Pankaj Gupta");
		newsData.setDate("May 26, 2013, 13:35");
		newsData.setName("bbbbbbbbbbbbbbbbbbbbb");
		newsData.setUrl("http://facebook.com");
		results.add(newsData);

		newsData = new NewsItem();
		newsData.setHeadline("BCCI suspends Gurunath pending inquiry ");
		newsData.setReporterName("Rajiv Chandan");
		newsData.setDate("May 26, 2013, 13:35");
		newsData.setName("ccccccccccccccccccccc");
		results.add(newsData);

		newsData = new NewsItem();
		newsData.setHeadline("Life convict can`t claim freedom after 14 yrs: SC");
		newsData.setReporterName("Pankaj Gupta");
		newsData.setDate("May 26, 2013, 13:35");
		newsData.setName("ddddddddddddddddddddd");
		results.add(newsData);

		newsData = new NewsItem();
		newsData.setHeadline("Indian Army refuses to share info on soldiers mutilated at LoC");
		newsData.setReporterName("Pankaj Gupta");
		newsData.setDate("May 26, 2013, 13:35");
		newsData.setName("eeeeeeeeeeeeeeeeeeeee");
		results.add(newsData);

		newsData = new NewsItem();
		newsData.setHeadline("French soldier stabbed; link to Woolwich attack being probed");
		newsData.setReporterName("Sudeep Nanda");
		newsData.setDate("May 26, 2013, 13:35");
		newsData.setName("fffffffffffffffffffff");
		results.add(newsData);

		return results;
	}
	
	public void HTTPClient()
	{
		ArrayList<BasicNameValuePair> parameters = new ArrayList<BasicNameValuePair>();
		handler = new Handler(new Callback() 
		{
			@Override
			public boolean handleMessage(Message msg) 
			{
				Bundle data = msg.getData();
				if (data.getInt("error") == 1)
				{
					//XXX ERROR HANDLING
					return false;
				} 
				else if (data.getInt("error") == 0)
				{
					//XXX NORMAL WORK
					// use activity.runOnUIThread() for UI calls
					final AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this)
					.setMessage(data.getString("response"))
					.setPositiveButton("OK", new OnClickListener()
					{
						@Override
						public void onClick(DialogInterface dialog, int which) 
						{
							dialog.dismiss();
						}
					}).create();
					
					runOnUiThread(new Runnable()
					{
						
						@Override
						public void run()
						{
							alertDialog.show();
						}
					});
					return false;
				}
				
				return false;
			}
		});
        
        //AsyncHttpGetClient asyncHttpGetClient = new AsyncHttpGetClient(MainActivity.this, url, parameters , handler);
        AsyncHttpPostClient asyncHttpPostClient = new AsyncHttpPostClient(MainActivity.this, url, parameters , handler);
        asyncHttpPostClient.execute("");
	}

}
