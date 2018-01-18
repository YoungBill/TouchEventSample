# TouchEventSample
A sample of android onTouchEvent handling mechanism
## 一. 概述
1.只有view，ViewGroup，Activity 具有事件分发和消费的功能。
<br/>2.Activity因为上最先接触到触摸事件，因此Activity没有事件拦截方法。即没有onInterceptTouchEvent方法。
<br/>3.对于不能添加子控件的view，不能对事件进行分发和拦截，它只有onTouchEvent事件。
 
## 二.3个方法
1.public boolean dispatchTouchEvent(MotionEvent ev)
<br/>
当触摸事件发生的时候，首先会被当前的activity进行分发，即当前activity的dispatchTouchEvent方法会被执行。
这个时候,该方法有三种返回的情况：
<br/>return false： 表明事件不会被进行分发。事件会以冒泡的方式被传递给上层的view或activity的onTouchEvent方法进行消费掉。
<br/>return true：表明该事件已经被处理。事件会被当前view或activity的dispatchTouchEvent给消费掉。不会再进行传递，事件到此结束。
<br/>return super.dispatchTouchEvent(ev)：表明该事件将会被分发。此时当前View的onIntercepterTouchEvent方法会捕获该事件，判断需不需要进行事件的拦截。

2.public boolean onInterceptTouchEvent(MotionEvent ev)     
<br/>该方法用户拦截被传递过来的事件，用于判断被传递过来的事件是否需要被当前的view进行处理。
<br/>return false : 不对事件进行拦截，放行该事件。事件会被传递到当前view的子控件中，由子控件中的dispatchTouchEvent方法进行分发处理。
<br/>return true : 拦截该事件，将该事件交给当前view的onTouchEvent方法进行处理。
<br/>return super.inInterceptTouchEvent(ev)：默认拦截方式，和return true一样。该事件会被拦截，将该事件交给当前view的onTouchEvent方法进行处理。（这里需要有一点说明，当有两个view。A view中有一个B view.点击A.A中如果onInterceptTouchEvent()返回super.interceptTouchEvent(ev),则事件将会被A进行拦截，交给A的onTouchEvent()进行处理，如果点击的是B，A中如果onInterceptTouchEvent()返回super.interceptTouchEvent(ev)，则事件将不会被拦截，会被分发到子控件中）
注：onInterceptTouchEvent仅在当前视图具有从onTouchEvent返回“true”的子视图时才会被调用。 一旦子视图onTouchEvent返回“true”，父视图就有机会截获该事件。
 
3.public boolean onTouchEvent(MotionEvent event)
<br/>当前的view把事件进行了拦截，则事件则会被传递到该方法中
<br/>return false：表明没有消费该事件，事件将会以冒泡的方式一直被传递到上层的view或Activity中的onTouchEvent事件处理。如果最上层的view或Activity中的onTouchEvent还是返回false。则该事件将消失。接下来来的一系列事件都将会直接被上层的onTouchEvent方法捕获
<br/>return true: 表明消费了该事件，事件到此结束。
<br/>return super.onTouchEvent(event)：默认情况，和return false一样。
