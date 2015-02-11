package ca.ualberta.cs.lonelytwitter.test;

import ca.ualberta.cs.lonelytwitter.IntentReaderActivity;
import android.content.Intent;
import android.test.ActivityInstrumentationTestCase2;
import android.test.ViewAsserts;
import android.widget.TextView;
import ca.ualberta.cs.lonelytwitter.R;
import java.lang.Object;


public class IntentReaderAcitivityTest extends
		ActivityInstrumentationTestCase2<IntentReaderActivity>
{
	public IntentReaderAcitivityTest(){
		super(IntentReaderActivity.class);
	}
	public void setup() throws Exception{
		super.setUp();
	}
	public void testSendText(){
		String text="Hello";
		IntentReaderActivity activity=startWithText(text, IntentReaderActivity.NORMAL);
		assertEquals("Is the activity getting my text", text, activity.getText());
	}
	public void textDoubleText(){
		String text="Hi";
			IntentReaderActivity activity=startWithText(text, IntentReaderActivity.DOUBLE);
		assertEquals("is the activity geting my text", text+text,activity.getText());
	}
	
	public void testDisplayText(String text){
		IntentReaderActivity activity=startWithText("Hello", IntentReaderActivity.NORMAL);
		TextView view=(TextView) activity.findViewById(R.id.intentText);
		assertEquals("display correct text?", "hello",view.getText());
	}
	
	
	
	private IntentReaderActivity startWithText(String text, int transform_code){
		Intent intent= new Intent();
		intent.putExtra(IntentReaderActivity.TEXT_KEY, text);
		intent.putExtra(IntentReaderActivity.TRANSFORM_KEY,transform_code);
		setActivityIntent(intent);
		return (IntentReaderActivity) getActivity();
		
		}
	public void testReverseText(){
		IntentReaderActivity activity=startWithText("Hello", IntentReaderActivity.REVERSE);
		TextView view=(TextView) activity.findViewById(R.id.intentText);
		ViewAsserts v=activity.getWindow().getDecorView();
	}
}
