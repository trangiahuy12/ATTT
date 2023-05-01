package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.DigitalSignatureView;

public class DigitalSignatureController implements ActionListener {
	private DigitalSignatureView view;
	
	
	
	public DigitalSignatureController(DigitalSignatureView view) {
		this.view = view;
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if (command.equals("Tạo key")) {
			this.view.model.generate();
			this.view.displayKey();
		}
		else if (command.equals("Chọn file")) {
			this.view.chooseFile_1();
		}
		else if (command.equals("Tạo chữ ký đi kèm")) {
			this.view.signFile();
		}
		else if (command.equals("Chọn file cần xác thực")) {
			this.view.chooseFile_2();
		}
		else if (command.equals("Xác thực")) {
			this.view.verifyFile();
		}
	}
	
}
