package controle;

import javax.swing.text.*;

// Classe que filtra o que pode ser digitado no JTextField, a partir de um regex
@SuppressWarnings("serial")
public class JTextFieldFilter extends PlainDocument {
	private String regex;
	
    public JTextFieldFilter(String regex) {
        super();
        this.regex = regex;
    }

    @Override
    public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
    	
    	for( int i = 0; i < str.length(); i++ )
    		
			if(!str.matches(regex))
				return;

		super.insertString( offset, str, attr );
    }
}
