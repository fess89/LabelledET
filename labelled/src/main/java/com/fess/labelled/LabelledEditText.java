package com.fess.labelled;

/**
 * This custom EditText contains a label inside the edittext itself.
 * All data stored in such EditTexts is a profile item.
 *
 * The class extends com.neopixl.pixlui.components.edittext.EditText
 * in order to have custom fonts enabled easily.
 *
 * Created by fess on 12/3/13.
 */
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.widget.EditText;

public class LabelledEditText extends EditText
{
	protected String label = null;
	protected Integer lines = 0;

	protected int mPaddingLeft;
	protected int mPaddingRight;
	protected int mPaddingTop;
	protected int mPaddingBottom;

	public LabelledEditText(Context context)
	{
		super(context);
		mPaddingLeft = getPaddingLeft();
	}

	public LabelledEditText(Context context, AttributeSet attrs)
	{
		super(context, attrs);
		mPaddingLeft = getPaddingLeft();
		TypedArray typedArray = null;
		try
		{
			typedArray = context.getTheme().obtainStyledAttributes(attrs, R.styleable.LabelledEditText, 0, 0);
		}
		catch (NullPointerException e)
		{
			e.printStackTrace();
		}

		if (typedArray != null)
		{
			this.label = typedArray.getString(R.styleable.LabelledEditText_label) + ": ";
			this.lines = typedArray.getInteger(R.styleable.LabelledEditText_lines, 0);
			typedArray.recycle();
		}
	}

	protected void onDraw(Canvas canvas)
	{
		TextPaint textPaint = getPaint();
		Rect size = new Rect();
		textPaint.getTextBounds(label + ":", 0, (label+":").length(), size);

		mPaddingTop = getPaddingTop();
		mPaddingBottom = getPaddingBottom();
		mPaddingRight = getPaddingRight();

		int height = getHeight();

		setPadding(mPaddingLeft + size.width(), mPaddingTop, mPaddingRight, mPaddingBottom);
		super.onDraw(canvas);

		if (this.lines != 0)
		{
			canvas.drawText(label, mPaddingLeft + size.left, (1 + height - mPaddingBottom - mPaddingTop)/this.lines, textPaint);
		}
		else
		{
			canvas.drawText(label, mPaddingLeft + size.left, 1 + height - mPaddingBottom - mPaddingTop, textPaint);
		}
	}

	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec)
	{
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
	}
}