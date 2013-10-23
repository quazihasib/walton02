package com.example.lauch;

public class NewsItem  
{

	private String headline;
	private String reporterName;
	private String date;
	
	private String shortName;
	private String nameCode;
	private String url;

	public String getHeadline()
	{
		return headline;
	}

	public void setHeadline(String headline) 
	{
		this.headline = headline;
	}

	public String getReporterName() 
	{
		return reporterName;
	}

	public void setReporterName(String reporterName) 
	{
		this.reporterName = reporterName;
	}

	public String getDate() 
	{
		return date;
	}

	public void setDate(String date) 
	{
		this.date = date;
	}
	//Experimental
	//1
	public String getShortName() 
	{
		return shortName;
	}

	public void setName(String shortName) 
	{
		this.shortName = shortName;
	}
	//2
	public String getNameCode() 
	{
		return nameCode;
	}

	public void setNameCode(String nameCode) 
	{
		this.nameCode = nameCode;
	}
	//3
	public String getUrl() 
	{
		return url;
	}

	public void setUrl(String url) 
	{
		this.url = url;
	}

	@Override
	public String toString()
	{
		return "[ headline=" + headline + ", reporter Name=" + 
				reporterName + " , date=" + date + "]";
	}
}
