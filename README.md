LabelledEditText
================

A custom TextView for Android which includes a customizable label inside. The label cannot be deleted.

The initial code was done by Xavier Gouchet (github@xgouchet.fr), later I customized.

There is a couple of custom parameters:

labelled:label - the text you want to appear as a label

labelled:lines - the number of lines the EditText takes in the GUI (have yet to investigate about maxLines and minLines). Note that you should use it together with android:lines to work properly.

Usage
-----

    git clone https://github.com/fess89/LabelledEditText

Add the project as a module in Android Studio, then add it as a module dependency to your project. The setup for Eclipse should be similar. If you're stuck with the setup, it is of course possible to just copy the required files (LabelledEditText.java and attrs.xml) to your project.

In your layout, you may then do something like:

    <LinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:labelled="com.fess.app"
    android:orientation="vertical"
    android:layout_width="fill_parent"
    android:layout_height="fill_parent">
    
      <com.fess.app.LabelledEditText
        android:layout_width="fill_parent"
        android:layout_height="wrap_content"
        labelled:label="Single Line"
        labelled:lines="1"/>
  
      <com.fess.app.LabelledEditText
        android:layout_width="fill_parent"
        android:layout_height="wrap_content"
        android:lines="3"
        labelled:label="Multiline"
        labelled:lines="3"/>
  
    </LinearLayout>



