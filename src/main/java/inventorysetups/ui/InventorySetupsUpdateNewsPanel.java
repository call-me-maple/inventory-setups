package inventorysetups.ui;

import inventorysetups.InventorySetupsPlugin;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.FontManager;
import net.runelite.client.util.LinkBrowser;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import static inventorysetups.InventorySetupsPlugin.TUTORIAL_LINK;

public class InventorySetupsUpdateNewsPanel extends JPanel
{

	InventorySetupsUpdateNewsPanel(InventorySetupsPlugin plugin, InventorySetupsPluginPanel panel)
	{
		final JLabel welcomeText = new JLabel("Inventory Setups " + plugin.getCurrentVersionString());
		welcomeText.setFont(FontManager.getRunescapeBoldFont());
		welcomeText.setHorizontalAlignment(JLabel.CENTER);

		final JPanel welcomePanel = new JPanel(new BorderLayout());
		welcomePanel.add(welcomeText, BorderLayout.NORTH);

		final JPanel latestUpdatePanelInfo = getLatestUpdateInfoPanel();


		final JLabel newUser = new JLabel("Are you a new user?");
		final JLabel newUser2 = new JLabel("For help and support, click here");
		final JButton linkToHelp = new JButton("View Guide");
		linkToHelp.addActionListener(e ->
		{
			LinkBrowser.browse(TUTORIAL_LINK);
		});
		newUser.setFont(FontManager.getRunescapeSmallFont());
		newUser2.setFont(FontManager.getRunescapeSmallFont());
		newUser.setHorizontalAlignment(JLabel.CENTER);
		newUser2.setHorizontalAlignment(JLabel.CENTER);

		final JPanel newUserPanelInfo = new JPanel();
		newUserPanelInfo.setLayout(new BorderLayout());
		newUserPanelInfo.add(newUser, BorderLayout.NORTH);
		newUserPanelInfo.add(newUser2, BorderLayout.CENTER);
		newUserPanelInfo.add(linkToHelp, BorderLayout.SOUTH);

		final JPanel closePanel = new JPanel(new BorderLayout());
		final JButton returnToSetups = new JButton("Return to Setups");
		returnToSetups.addActionListener(e ->
		{
			plugin.setSavedVersionString(plugin.getCurrentVersionString());
			panel.rebuild(true);
		});
		final JLabel clickButtonToLeave = new JLabel("Click here to hide this window");
		final JLabel clickButtontoLeave2 = new JLabel("until the next update");
		clickButtonToLeave.setFont(FontManager.getRunescapeSmallFont());
		clickButtontoLeave2.setFont(FontManager.getRunescapeSmallFont());
		clickButtonToLeave.setHorizontalAlignment(JLabel.CENTER);
		clickButtontoLeave2.setHorizontalAlignment(JLabel.CENTER);
		closePanel.add(clickButtonToLeave, BorderLayout.NORTH);
		closePanel.add(clickButtontoLeave2, BorderLayout.CENTER);
		closePanel.add(returnToSetups, BorderLayout.SOUTH);

		final JPanel contentPanel = new JPanel();
		contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
		contentPanel.add(welcomePanel);
		contentPanel.add(Box.createRigidArea(new Dimension(0, 20)));
		contentPanel.add(latestUpdatePanelInfo);
		contentPanel.add(Box.createRigidArea(new Dimension(0, 20)));
		contentPanel.add(newUserPanelInfo);
		contentPanel.add(Box.createRigidArea(new Dimension(0, 20)));
		contentPanel.add(closePanel);

		setLayout(new BorderLayout());
		setBorder(new EmptyBorder(10, 10, 10, 10));
		add(contentPanel, BorderLayout.CENTER);
	}


	private JPanel getLatestUpdateInfoPanel()
	{
		final JLabel patchNotesLabel = new JLabel("Patch Notes");
		patchNotesLabel.setFont(FontManager.getRunescapeSmallFont());
		patchNotesLabel.setHorizontalAlignment(JLabel.CENTER);

		final JPanel patchTitlePanel = new JPanel(new BorderLayout());
		patchTitlePanel.add(patchNotesLabel, BorderLayout.NORTH);

		String updateText = "Added update window to provide information about new updates.\n\n" +
									"Added configuration option to make all slots fuzzy in new setups. Check the plugin settings to enable this.\n\n" +
									"Added fuzzy toggle for additional filtered items. You can now right click additional filtered item slots and set them to fuzzy.\n\n" +
									"Changed stack differences to be slot specific. You can now right click inventory, equipment, and rune pouch slots to individually set the stack difference mode.";

		JTextArea textArea = new JTextArea(2, 20);
		textArea.setText(updateText);
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		textArea.setOpaque(false);
		textArea.setEditable(false);
		textArea.setFocusable(false);
		textArea.setBackground(ColorScheme.DARK_GRAY_COLOR);
		textArea.setFont(FontManager.getRunescapeSmallFont());
		textArea.setBorder(new EmptyBorder(0, 0, 0, 0));

		final JPanel contentPanel = new JPanel();
		contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
		contentPanel.add(patchTitlePanel, BorderLayout.NORTH);
		contentPanel.add(Box.createRigidArea(new Dimension(0, 3)));
		contentPanel.add(getJSeparator(ColorScheme.LIGHT_GRAY_COLOR));
		contentPanel.add(Box.createRigidArea(new Dimension(0, 3)));
		contentPanel.add(textArea);
		contentPanel.add(Box.createRigidArea(new Dimension(0, 3)));
		contentPanel.add(getJSeparator(ColorScheme.LIGHT_GRAY_COLOR));

		final JPanel updatePanel = new JPanel(new BorderLayout());
		updatePanel.add(contentPanel, BorderLayout.CENTER);

		return updatePanel;
	}

	private JSeparator getJSeparator(Color color)
	{
		JSeparator sep = new JSeparator();
		sep.setBackground(color);
		sep.setForeground(color);
		return sep;
	}

}