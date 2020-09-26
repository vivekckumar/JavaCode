import java.awt.event.*;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.net.URL;

@SuppressWarnings("serial")
public class SlideShowApplet extends JApplet implements ActionListener{
	
	JLabel display = new JLabel();
	JButton back = new JButton("Back");
	JButton stop = new JButton("Stop");
	JButton next = new JButton("Next");
	int currentImage = 0;
	String images[] = { "image0.jpg", "image1.jpg", "image2.jpg" };

	public void init()
	{
		JPanel buttons = new JPanel(new FlowLayout());
		buttons.add(back);
		buttons.add(stop);
		buttons.add(next);
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add("Center", display);

		getContentPane().add("South", buttons);
		back.addActionListener(this);
		stop.addActionListener(this);
		next.addActionListener(this);
	}

	public void showCurrentImage()
	{
		try	{
				URL image = new URL(getDocumentBase(), images[currentImage]);
				display.setIcon(new ImageIcon(image));
		}catch(Exception ex)	{

			JOptionPane.showMessageDialog(this, "Error image " + currentImage);
			}
	}
	public void showNextImage()
	{
		currentImage = currentImage + 1;
		if (currentImage >= images.length)
			currentImage = 0;
		showCurrentImage();
	}
	public void showPreviousImage()
	{
		currentImage = currentImage - 1;
		if (currentImage < 0)
			currentImage = images.length - 1;
		showCurrentImage();
	}
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == next)
			showNextImage();
		else if (e.getSource() == back)
			showPreviousImage();
	}
}