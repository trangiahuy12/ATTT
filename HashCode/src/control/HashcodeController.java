package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.HashcodeView;

public class HashcodeController implements ActionListener {
	private HashcodeView view;
	
	
	
	public HashcodeController(HashcodeView model) {
		super();
		this.view = model;
	}



	public HashcodeView getModel() {
		return view;
	}



	public void setModel(HashcodeView model) {
		this.view = model;
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		String request = e.getActionCommand();
		if (request.equals("Mã Hoá")) {
			this.view.maHoa();
		}
		else if (request.equals("Xoá Rỗng")) {
			this.view.xoaRong();
		}
	}

}
