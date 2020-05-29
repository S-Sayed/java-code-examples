package com.ssayed.examples.behavioral.command;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

// client
public class CommandPatternExample {

	private JTextArea textArea;
	private JTextField textField;

	public static void main(String[] args) {
		CommandPatternExample example = new CommandPatternExample();
		example.buildFrame();
	}

	private void buildFrame() {
		JFrame frame = new JFrame("Customer Search");

		JPanel content = new JPanel();
		frame.setContentPane(content);

		JLabel searchLabel = new JLabel("Enter Search Value");
		content.add(searchLabel);

		textField = new JTextField();
		textField.setLayout(null);
		textField.setPreferredSize(new Dimension(290, 20));
		content.add(textField);

		JPanel buttons = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JButton mobileNo = new JButton("By Mobile #");
		JButton email = new JButton("By Email");
		JButton nationalID = new JButton("By National ID");
		JButton previousSearch = new JButton("Prev Search");

		SearchInvoker searchInvoker = new SearchInvoker();
		mobileNo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SearchCriteria criteria = new SearchCriteria();
				criteria.setSearcType("MOBILE_NUMBER");
				criteria.setSeachValue(textField.getText());
				SearchResult result = searchInvoker.executeCommand(new MobileNumberSearch(criteria));
				displayResult(criteria, result);
			}
		});

		email.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SearchCriteria criteria = new SearchCriteria();
				criteria.setSearcType("EMAIL");
				criteria.setSeachValue(textField.getText());
				SearchResult result = searchInvoker.executeCommand(new EmailSearch(criteria));
				displayResult(criteria, result);
			}
		});

		nationalID.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SearchCriteria criteria = new SearchCriteria();
				criteria.setSearcType("NATIONAL_ID");
				criteria.setSeachValue(textField.getText());
				SearchResult result = searchInvoker.executeCommand(new NationalIDSearch(criteria));
				displayResult(criteria, result);
			}
		});

		previousSearch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				if (searchInvoker.getSearchHistory().isEmpty()) {
					textField.setText("");
					textArea.setText("No previous search found");
				} else {
					SearchCommand searchCommand = searchInvoker.getSearchHistory().pop();
					SearchResult result = searchInvoker.executeCommandFromHistory(searchCommand);
					textField.setText(searchCommand.getSearchCriteria().getSeachValue());
					displayResult(searchCommand.getSearchCriteria(), result);
				}
			}
		});

		buttons.add(mobileNo);
		buttons.add(email);
		buttons.add(nationalID);
		buttons.add(previousSearch);
		content.add(buttons);

		textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setPreferredSize(new Dimension(400, 80));
		content.add(textArea);

		frame.setSize(450, 200);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}

	private void displayResult(SearchCriteria criteria, SearchResult result) {
		textArea.setText(criteria != null ? criteria.toString() : "");
		textArea.append("\n-------------------------\n");
		textArea.append(result != null ? result.toString() : "No data Found");
	}
}
