package com.edh.graphics;
import java.util.*;

import com.edh.utility.*;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.*;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;



public class DrawPanel extends Thread{

	public List<Node> path = new ArrayList<Node>();
	static private MyMap map;
	final static Display display = new Display();
	static int style = SWT.SHELL_TRIM;//|SWT.DOUBLE_BUFFERED;
	private Thread thread;
	final static Shell shell = new Shell(display,style);
	static Canvas canvas;
	protected static final int TIMER_INTERVAL = 2;
	private boolean started = false;


	public DrawPanel(int xSize, int ySize){
		MyMap mapGraph = new MyMap();
		mapGraph.setPanel(this);
		map = mapGraph;
		MyMap mappy = new MyMap();
		shell.setBounds(0, 0, xSize, ySize);
		shell.setLayout(new RowLayout(SWT.VERTICAL)); 
		createContents(shell);
		shell.open ();

		Node noddy = new Node(1,1,39,39,40,40,mappy,mapGraph);
		thread = new Thread(noddy);

		Runnable runnable = new Runnable() {

			public void run() {
				animate();
			}

		};


		while (!shell.isDisposed()) {

			if (!display.readAndDispatch()) {

				display.timerExec(TIMER_INTERVAL, runnable);

				display.sleep();

				display.readAndDispatch();

				display.timerExec(-1, runnable);

			}

		}

		display.dispose();

	}


	private void createContents(final Shell shell) {
		GridLayout gridLayout = new GridLayout();
		GridData gridData = new GridData();
		gridLayout.numColumns = 1;

		shell.setLayout(gridLayout);

		Button button1 = new Button(shell, SWT.PUSH);
		button1.setText("Start search");
		button1.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_CENTER));
		button1.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				if(!started){
					started = true;
					thread.start();
				}
			}
		});


		gridData.verticalAlignment = GridData.FILL;
		gridData.verticalSpan = 0;
		gridData.grabExcessVerticalSpace = true;
		gridData.horizontalAlignment = GridData.FILL;
		gridData.grabExcessHorizontalSpace = true;

		canvas = new Canvas(shell, SWT.NONE| SWT.NO_BACKGROUND |SWT.DOUBLE_BUFFERED);
		canvas.setLayoutData(gridData);
		canvas.addPaintListener(new PaintListener() {
			public void paintControl(PaintEvent event) {
				paintComp(event);
			}
		});
	}


	private class painter implements PaintListener {

		public void paintControl(PaintEvent e) {
			paintComp(e);
			e.gc.dispose();
		}
	}

	public void repaint(){ 

	}

	public void animate(){
		canvas.redraw();
	}

	/** return a color darker than the input c (ratio 0.75) */
	public Color getDarker (Color c) {
		return getDarker (c, 0.75F);
	}

	/** return a color darker than the input c by the given ratio */
	public Color getDarker (Color c, float ratio) {
		int r = (int) (c.getRed() * ratio);
		int g = (int) (c.getGreen() * ratio);
		int b = (int) (c.getBlue() * ratio);
		return new Color (display, r, g, b);
	}


	public void paintComp(PaintEvent event)  // draw graphics in the panel
	{


		GC g = event.gc;
		g.setAntialias(SWT.OFF); 
		Color magenta = display.getSystemColor(SWT.COLOR_MAGENTA);
		Color blue = display.getSystemColor(SWT.COLOR_BLUE);
		Color green = display.getSystemColor(SWT.COLOR_GREEN);
		Color black = display.getSystemColor(SWT.COLOR_BLACK);
		Color gray = display.getSystemColor(SWT.COLOR_GRAY);
		Color yellow = display.getSystemColor(SWT.COLOR_YELLOW);
		g.setForeground(black);
		Rectangle clientArea = shell.getClientArea();
		g.setBackground(gray);

		g.fillRectangle(clientArea);
		int width = clientArea.width; 
		int height = clientArea.height; 

		int extraWidth = width - map.ySize*10;
		int extraHeight = height - map.xSize*10;

		int W = extraWidth/2;
		int H = extraHeight/2;


		for(int x = 0; x < map.xSize+1; x++){
			for(int y = 0; y < map.ySize+1; y++){
				if(map.getSection(x,y) == 3){
					g.drawRectangle(y*10+W,x*10 +H,10,10); 
					g.setBackground(magenta); 
					g.fillRectangle(y*10+W,x*10 +H,10,10); 
				}
				if(map.getSection(x,y) == 8 || map.getSection(x,y) == 2 ||map.getSection(x,y) == 9){
					g.drawRectangle(y*10+W,x*10 +H,10,10); 
					g.setBackground(blue); 
					g.fillRectangle(y*10+W,x*10 +H,10,10); 
				}
				if(map.getSection(x,y) == 6 || map.getSection(x,y) == 4 ){
					g.drawRectangle(y*10+W,x*10 +H,10,10); 
					g.setBackground(getDarker(magenta)); 
					g.fillRectangle(y*10+W,x*10 +H,10,10);
				}
				if(map.getSection(x,y) == 12){
					g.drawRectangle(y*10+W,x*10 +H,10,10); 
					g.setBackground(getDarker(green)); 
					g.fillRectangle(y*10+W,x*10 +H,10,10);
				}
				if(map.getSection(x,y) == 1){
					g.drawRectangle(y*10+W,x*10 +H,10,10); 
					g.setBackground(green); 
					g.fillRectangle(y*10+W,x*10 +H,10,10);
				}
				g.drawRectangle(y*10+W,x*10 +H,10,10); 
			}
		}
		for(int i = 0; i < path.size(); i++){
			g.setLineWidth(4);

			g.setAntialias(SWT.ON); 
			g.setForeground(yellow);
			g.setLineCap(SWT.CAP_ROUND);
			g.setLineJoin(SWT.JOIN_ROUND);
			int x1 = path.get(i).getY()*10 + W +5;
			int y1 = path.get(i).getX()*10 + H + 5;
			int x2 = path.get(i).getParent().getY()*10 + W +5 ;
			int y2 = path.get(i).getParent().getX()*10 + H +5 ;
			g.drawLine(x1,y1,x2,y2);
		}

	}

}