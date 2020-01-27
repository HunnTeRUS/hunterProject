package controller;

import org.apache.commons.mail.SimpleEmail;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class SendEmails {
	SimpleEmail sendEmail = new SimpleEmail();

	static SendEmails objEmail = new SendEmails();

	public void enviandoEmail(String emailPerson, String code) {
		final String username = "imhunnterus@gmail.com";
		final String password = "hunter@147";

		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "587");
        props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "587");

		Session session = Session.getDefaultInstance(props,
			new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(username, password);
				}
			});

		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("otavio@gmail.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailPerson));
			message.setSubject("App Hunter");
			message.setContent("\n" + 
					"\n" + 
					"\n" + 
					"\n" + 
					"<!DOCTYPE html>\n" + 
					"<html>\n" + 
					"<head>\n" + 
					"\n" + 
					"<title>Adm Verification</title>\n" + 
					"<link rel=\"shortcut icon\" href=\"favicon.ico\">\n" + 
					"\n" + 
					"<style type=\"text/css\">\n" + 
					"table[name=\"blk_permission\"], table[name=\"blk_footer\"] {display:none;}\n" + 
					"</style>\n" + 
					"\n" + 
					"<meta name=\"googlebot\" content=\"noindex\" />\n" + 
					"<META NAME=\"ROBOTS\" CONTENT=\"NOINDEX, NOFOLLOW\"/><link rel=\"stylesheet\" href=\"/style/dhtmlwindow.css\" type=\"text/css\" />\n" + 
					"<script type=\"text/javascript\" src=\"/script/dhtmlwindow.js\">\n" + 
					"/***********************************************\n" + 
					"* DHTML Window Widget- � Dynamic Drive (www.dynamicdrive.com)\n" + 
					"* This notice must stay intact for legal use.\n" + 
					"* Visit www.dynamicdrive.com for full source code\n" + 
					"***********************************************/\n" + 
					"</script>\n" + 
					"<link rel=\"stylesheet\" href=\"/style/modal.css\" type=\"text/css\" />\n" + 
					"<script type=\"text/javascript\" src=\"/script/modal.js\"></script>\n" + 
					"<script type=\"text/javascript\">\n" + 
					"	function show_popup(popup_name,popup_url,popup_title,width,height) {var widthpx = width +  \"px\";var heightpx = height +  \"px\";emailwindow = dhtmlmodal.open(popup_name , 'iframe', popup_url , popup_title , 'width=' + widthpx + ',height='+ heightpx + ',center=1,resize=0,scrolling=1');}\n" + 
					" function show_modal(popup_name,popup_url,popup_title,width,height){var widthpx = width +  \"px\";var heightpx = height +  \"px\";emailwindow = dhtmlmodal.open(popup_name , 'iframe', popup_url , popup_title , 'width=' + widthpx + ',height='+ heightpx + ',modal=1,center=1,resize=0,scrolling=1');}\n" + 
					"var popUpWin=0;\n" + 
					"	function popUpWindow(URLStr,PopUpName, width, height){if(popUpWin) { if(!popUpWin.closed) popUpWin.close();}var left = (screen.width - width) / 2;var top = (screen.height - height) / 2;popUpWin = open(URLStr, PopUpName,	'toolbar=0,location=0,directories=0,status=0,menub	ar=0,scrollbar=0,resizable=0,copyhistory=yes,width='+width+',height='+height+',left='+left+', 	top='+top+',screenX='+left+',screenY='+top+'');}\n" + 
					"</script>\n" + 
					"\n" + 
					"<meta content=\"width=device-width, initial-scale=1.0\" name=\"viewport\">\n" + 
					"<style type=\"text/css\">\n" + 
					"/*** BMEMBF Start ***/\n" + 
					"[name=bmeMainBody]{min-height:1000px;}\n" + 
					"@media only screen and (max-width: 480px){table.blk, table.tblText, .bmeHolder, .bmeHolder1, table.bmeMainColumn{width:100% !important;} }\n" + 
					"@media only screen and (max-width: 480px){.bmeImageCard table.bmeCaptionTable td.tblCell{padding:0px 20px 20px 20px !important;} }\n" + 
					"@media only screen and (max-width: 480px){.bmeImageCard table.bmeCaptionTable.bmeCaptionTableMobileTop td.tblCell{padding:20px 20px 0 20px !important;} }\n" + 
					"@media only screen and (max-width: 480px){table.bmeCaptionTable td.tblCell{padding:10px !important;} }\n" + 
					"@media only screen and (max-width: 480px){table.tblGtr{ padding-bottom:20px !important;} }\n" + 
					"@media only screen and (max-width: 480px){td.blk_container, .blk_parent, .bmeLeftColumn, .bmeRightColumn, .bmeColumn1, .bmeColumn2, .bmeColumn3, .bmeBody{display:table !important;max-width:600px !important;width:100% !important;} }\n" + 
					"@media only screen and (max-width: 480px){table.container-table, .bmeheadertext, .container-table { width: 95% !important; } }\n" + 
					"@media only screen and (max-width: 480px){.mobile-footer, .mobile-footer a{ font-size: 13px !important; line-height: 18px !important; } .mobile-footer{ text-align: center !important; } table.share-tbl { padding-bottom: 15px; width: 100% !important; } table.share-tbl td { display: block !important; text-align: center !important; width: 100% !important; } }\n" + 
					"@media only screen and (max-width: 480px){td.bmeShareTD, td.bmeSocialTD{width: 100% !important; } }\n" + 
					"@media only screen and (max-width: 480px){td.tdBoxedTextBorder{width: auto !important;}}\n" + 
					"@media only screen and (max-width: 480px){table.blk, table[name=tblText], .bmeHolder, .bmeHolder1, table[name=bmeMainColumn]{width:100% !important;} }\n" + 
					"@media only screen and (max-width: 480px){.bmeImageCard table.bmeCaptionTable td[name=tblCell]{padding:0px 20px 20px 20px !important;} }\n" + 
					"@media only screen and (max-width: 480px){.bmeImageCard table.bmeCaptionTable.bmeCaptionTableMobileTop td[name=tblCell]{padding:20px 20px 0 20px !important;} }\n" + 
					"@media only screen and (max-width: 480px){table.bmeCaptionTable td[name=tblCell]{padding:10px !important;} }\n" + 
					"@media only screen and (max-width: 480px){table[name=tblGtr]{ padding-bottom:20px !important;} }\n" + 
					"@media only screen and (max-width: 480px){td.blk_container, .blk_parent, [name=bmeLeftColumn], [name=bmeRightColumn], [name=bmeColumn1], [name=bmeColumn2], [name=bmeColumn3], [name=bmeBody]{display:table !important;max-width:600px !important;width:100% !important;} }\n" + 
					"@media only screen and (max-width: 480px){table[class=container-table], .bmeheadertext, .container-table { width: 95% !important; } }\n" + 
					"@media only screen and (max-width: 480px){.mobile-footer, .mobile-footer a{ font-size: 13px !important; line-height: 18px !important; } .mobile-footer{ text-align: center !important; } table[class=\"share-tbl\"] { padding-bottom: 15px; width: 100% !important; } table[class=\"share-tbl\"] td { display: block !important; text-align: center !important; width: 100% !important; } }\n" + 
					"@media only screen and (max-width: 480px){td[name=bmeShareTD], td[name=bmeSocialTD]{width: 100% !important; } }\n" + 
					"@media only screen and (max-width: 480px){td[name=tdBoxedTextBorder]{width: auto !important;}}\n" + 
					"@media only screen and (max-width: 480px){.bmeImageCard table.bmeImageTable{height: auto !important; width:100% !important; padding:20px !important;clear:both; float:left !important; border-collapse: separate;} }\n" + 
					"@media only screen and (max-width: 480px){.bmeMblInline table.bmeImageTable{height: auto !important; width:100% !important; padding:10px !important;clear:both;} }\n" + 
					"@media only screen and (max-width: 480px){.bmeMblInline table.bmeCaptionTable{width:100% !important; clear:both;} }\n" + 
					"@media only screen and (max-width: 480px){table.bmeImageTable{height: auto !important; width:100% !important; padding:10px !important;clear:both; } }\n" + 
					"@media only screen and (max-width: 480px){table.bmeCaptionTable{width:100% !important;  clear:both;} }\n" + 
					"@media only screen and (max-width: 480px){table.bmeImageContainer{width:100% !important; clear:both; float:left !important;} }\n" + 
					"@media only screen and (max-width: 480px){table.bmeImageTable td{padding:0px !important; height: auto; } }\n" + 
					"@media only screen and (max-width: 480px){td.bmeImageContainerRow{padding:0px !important;}}\n" + 
					"@media only screen and (max-width: 480px){img.mobile-img-large{width:100% !important; height:auto !important;} }\n" + 
					"@media only screen and (max-width: 480px){img.bmeRSSImage{max-width:320px; height:auto !important;}}\n" + 
					"@media only screen and (min-width: 640px){img.bmeRSSImage{max-width:600px !important; height:auto !important;} }\n" + 
					"@media only screen and (max-width: 480px){.trMargin img{height:10px;} }\n" + 
					"@media only screen and (max-width: 480px){div.bmefooter, div.bmeheader{ display:block !important;} }\n" + 
					"@media only screen and (max-width: 480px){.tdPart{ width:100% !important; clear:both; float:left !important; } }\n" + 
					"@media only screen and (max-width: 480px){table.blk_parent1, table.tblPart {width: 100% !important; } }\n" + 
					"@media only screen and (max-width: 480px){.tblLine{min-width: 100% !important;}}\n" + 
					"@media only screen and (max-width: 480px){.bmeMblCenter img { margin: 0 auto; } }\n" + 
					"@media only screen and (max-width: 480px){.bmeMblCenter, .bmeMblCenter div, .bmeMblCenter span  { text-align: center !important; text-align: -webkit-center !important; } }\n" + 
					"@media only screen and (max-width: 480px){.bmeNoBr br, .bmeImageGutterRow, .bmeMblStackCenter .bmeShareItem .tdMblHide { display: none !important; } }\n" + 
					"@media only screen and (max-width: 480px){.bmeMblInline table.bmeImageTable, .bmeMblInline table.bmeCaptionTable, td.bmeMblInline { clear: none !important; width:50% !important; } }\n" + 
					"@media only screen and (max-width: 480px){.bmeMblInlineHide, .bmeShareItem .trMargin { display: none !important; } }\n" + 
					"@media only screen and (max-width: 480px){.bmeMblInline table.bmeImageTable img, .bmeMblShareCenter.tblContainer.mblSocialContain, .bmeMblFollowCenter.tblContainer.mblSocialContain{width: 100% !important; } }\n" + 
					"@media only screen and (max-width: 480px){.bmeMblStack> .bmeShareItem{width: 100% !important; clear: both !important;} }\n" + 
					"@media only screen and (max-width: 480px){.bmeShareItem{padding-top: 10px !important;} }\n" + 
					"@media only screen and (max-width: 480px){.tdPart.bmeMblStackCenter, .bmeMblStackCenter .bmeFollowItemIcon {padding:0px !important; text-align: center !important;} }\n" + 
					"@media only screen and (max-width: 480px){.bmeMblStackCenter> .bmeShareItem{width: 100% !important;} }\n" + 
					"@media only screen and (max-width: 480px){ td.bmeMblCenter {border: 0 none transparent !important;}}\n" + 
					"@media only screen and (max-width: 480px){.bmeLinkTable.tdPart td{padding-left:0px !important; padding-right:0px !important; border:0px none transparent !important;padding-bottom:15px !important;height: auto !important;}}\n" + 
					"@media only screen and (max-width: 480px){.tdMblHide{width:10px !important;} }\n" + 
					"@media only screen and (max-width: 480px){.bmeShareItemBtn{display:table !important;}}\n" + 
					"@media only screen and (max-width: 480px){.bmeMblStack td {text-align: left !important;}}\n" + 
					"@media only screen and (max-width: 480px){.bmeMblStack .bmeFollowItem{clear:both !important; padding-top: 10px !important;}}\n" + 
					"@media only screen and (max-width: 480px){.bmeMblStackCenter .bmeFollowItemText{padding-left: 5px !important;}}\n" + 
					"@media only screen and (max-width: 480px){.bmeMblStackCenter .bmeFollowItem{clear:both !important;align-self:center; float:none !important; padding-top:10px;margin: 0 auto;}}\n" + 
					"@media only screen and (max-width: 480px){\n" + 
					".tdPart> table{width:100% !important;}\n" + 
					"}\n" + 
					"@media only screen and (max-width: 480px){.tdPart>table.bmeLinkContainer{ width:auto !important; }}\n" + 
					"@media only screen and (max-width: 480px){.tdPart.mblStackCenter>table.bmeLinkContainer{ width:100% !important;}}\n" + 
					".blk_parent:first-child, .blk_parent{float:left;}\n" + 
					".blk_parent:last-child{float:right;}\n" + 
					"/*** BMEMBF END ***/\n" + 
					"\n" + 
					"table[name=\"bmeMainBody\"], body {background-color:#a6e9d7;}\n" + 
					" td[name=\"bmePreHeader\"] {background-color:transparent;}\n" + 
					" td[name=\"bmeHeader\"] {background:#ffffff;background-color:#1fc899;}\n" + 
					" td[name=\"bmeBody\"], table[name=\"bmeBody\"] {background-color:#ffffff;}\n" + 
					" td[name=\"bmePreFooter\"] {background-color:#ffffff;}\n" + 
					" td[name=\"bmeFooter\"] {background-color:transparent;}\n" + 
					" td[name=\"tblCell\"], .blk {font-family:initial;font-weight:normal;font-size:initial;}\n" + 
					" table[name=\"blk_blank\"] td[name=\"tblCell\"] {font-family:Arial, Helvetica, sans-serif;font-size:14px;}\n" + 
					" [name=bmeMainContentParent] {border-color:#808080;border-width:0px;border-style:none;border-radius:0px;border-collapse:separate;border-spacing:0px;overflow:hidden;}\n" + 
					" [name=bmeMainColumnParent] {border-color:transparent;border-width:0px;border-style:none;border-radius:0px;}\n" + 
					" [name=bmeMainColumn] {border-color:transparent;border-width:0px;border-style:none;border-radius:0px;border-collapse:separate;border-spacing:0px;}\n" + 
					" [name=bmeMainContent] {border-color:transparent;border-width:0px;border-style:none;border-radius:0px;border-collapse:separate;border-spacing:0px;}\n" + 
					"\n" + 
					"</style>\n" + 
					"</head>\n" + 
					"<body marginheight=0 marginwidth=0 topmargin=0 leftmargin=0 style=\"height: 100% !important; margin: 0; padding: 0; width: 100% !important;min-width: 100%;\">\n" + 
					"\n" + 
					"<table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" name=\"bmeMainBody\" style=\"background-color: rgb(166, 233, 215);\" bgcolor=\"#a6e9d7\"><tbody><tr><td width=\"100%\" valign=\"top\" align=\"center\">\n" + 
					"<table cellspacing=\"0\" cellpadding=\"0\" border=\"0\" name=\"bmeMainColumnParentTable\"><tbody><tr><td name=\"bmeMainColumnParent\" style=\"border-collapse: separate; border: 0px none transparent; border-radius: 0px;\">\n" + 
					"<table name=\"bmeMainColumn\" class=\"bmeHolder bmeMainColumn\" style=\"max-width: 600px; border-image: initial; border-radius: 0px; border-collapse: separate; border-spacing: 0px; overflow: visible;\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" align=\"center\"><tbody><tr><td width=\"100%\" class=\"blk_container bmeHolder\" name=\"bmePreHeader\" valign=\"top\" align=\"center\" style=\"color: rgb(102, 102, 102); border: 0px none transparent;\" bgcolor=\"\"></td></tr>   <tr><td width=\"100%\" class=\"bmeHolder\" valign=\"top\" align=\"center\" name=\"bmeMainContentParent\" style=\"border: 0px none rgb(128, 128, 128); border-radius: 0px; border-collapse: separate; border-spacing: 0px; overflow: hidden;\">\n" + 
					"<table name=\"bmeMainContent\" style=\"border-radius: 0px; border-collapse: separate; border-spacing: 0px; border: 0px none transparent;\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" align=\"center\"><tbody><tr><td width=\"100%\" class=\"blk_container bmeHolder\" name=\"bmeHeader\" valign=\"top\" align=\"center\" style=\"border: 0px none transparent; background-color: rgb(31, 200, 153); color: rgb(56, 56, 56);\" bgcolor=\"#1fc899\"><div id=\"dv_11\" class=\"blk_wrapper\" style=\"\">\n" + 
					"<table width=\"600\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" class=\"blk\" name=\"blk_divider\" style=\"\"><tbody><tr><td class=\"tblCellMain\" style=\"padding: 5px 20px;\">\n" + 
					"<table class=\"tblLine\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" width=\"100%\" style=\"border-top-width: 0px; border-top-style: none; min-width: 1px;\"><tbody><tr><td><span></span></td></tr></tbody>\n" + 
					"</table></td></tr></tbody>\n" + 
					"</table></div><div id=\"dv_3\" class=\"blk_wrapper\" style=\"\">\n" + 
					"<table class=\"blk\" name=\"blk_image\" width=\"600\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\"><tbody><tr><td>\n" + 
					"<table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\"><tbody><tr><td class=\"bmeImage\" style=\"padding: 20px; border-collapse: collapse;\" align=\"center\"></td></tr></tbody>\n" + 
					"</table></td></tr></tbody>\n" + 
					"</table></div><div id=\"dv_18\" class=\"blk_wrapper\" style=\"\">\n" + 
					"<table width=\"600\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" class=\"blk\" name=\"blk_divider\" style=\"\"><tbody><tr><td class=\"tblCellMain\" style=\"padding: 10px 20px;\">\n" + 
					"<table class=\"tblLine\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" width=\"100%\" style=\"border-top-width: 0px; border-top-style: none; min-width: 1px;\"><tbody><tr><td><span></span></td></tr></tbody>\n" + 
					"</table></td></tr></tbody>\n" + 
					"</table></div><div id=\"dv_1\" class=\"blk_wrapper\" style=\"\">\n" + 
					"<table width=\"600\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" class=\"blk\" name=\"blk_text\"><tbody><tr><td>\n" + 
					"<table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" width=\"100%\" class=\"bmeContainerRow\"><tbody><tr><td class=\"tdPart\" valign=\"top\" align=\"center\">\n" + 
					"<table cellspacing=\"0\" cellpadding=\"0\" border=\"0\" width=\"600\" name=\"tblText\" style=\"float:left; background-color:transparent;\" align=\"left\" class=\"tblText\"><tbody><tr><td valign=\"top\" align=\"left\" name=\"tblCell\" style=\"padding: 5px 20px; font-family: Arial, Helvetica, sans-serif; font-size: 14px; font-weight: 400; color: rgb(56, 56, 56); text-align: left;\" class=\"tblCell\"><div style=\"line-height: 125%; text-align: center;\"><span style=\"font-size: 48px; font-family: Impact, Chicago; color: #ffffff; line-height: 125%;\">\n" + 
					"<em><strong>Hi User!</strong></em></span></div></td></tr></tbody>\n" + 
					"</table></td></tr></tbody>\n" + 
					"</table></td></tr></tbody>\n" + 
					"</table></div><div id=\"dv_15\" class=\"blk_wrapper\" style=\"\">\n" + 
					"<table width=\"600\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" class=\"blk\" name=\"blk_text\"><tbody><tr><td>\n" + 
					"<table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" width=\"100%\" class=\"bmeContainerRow\"><tbody><tr><td class=\"tdPart\" valign=\"top\" align=\"center\">\n" + 
					"<table cellspacing=\"0\" cellpadding=\"0\" border=\"0\" width=\"600\" name=\"tblText\" style=\"float:left; background-color:transparent;\" align=\"left\" class=\"tblText\"><tbody><tr><td valign=\"top\" align=\"left\" name=\"tblCell\" style=\"padding: 5px 10px; font-family: Arial, Helvetica, sans-serif; font-size: 14px; font-weight: 400; color: rgb(56, 56, 56); text-align: left;\" class=\"tblCell\"><div style=\"line-height: 150%; text-align: center;\"><span style=\"font-size: 24px; font-family: Tahoma, Arial, Helvetica, sans-serif; color: #ffffff; line-height: 150%;\">You have requested to recovery your password, correct!? Here is your code to recovery your password. Good Studies!</span></div></td></tr></tbody>\n" + 
					"<br><br>\n" + 
					"<table cellspacing=\"0\" cellpadding=\"0\" border=\"0\" width=\"600\" name=\"tblText\" style=\"float:left; background-color:transparent;\" align=\"left\" class=\"tblText\"><tbody><tr><td valign=\"top\" align=\"left\" name=\"tblCell\" style=\"padding: 5px 10px; font-family: Arial, Helvetica, sans-serif; font-size: 14px; font-weight: 400; color: rgb(56, 56, 56); text-align: left;\" class=\"tblCell\"><div style=\"line-height: 50%; text-align: center;\"><span style=\"font-size: 20px; font-family: Tahoma, Arial, Helvetica, sans-serif; color: #ffffff; line-height: 50%; color: #ffffff;\"><br><br><br>Code: " + code + "\n" +
					"</table></td></tr></tbody>\n" + 
					"</table></td></tr></tbody>\n" + 
					"</table></div><div id=\"dv_17\" class=\"blk_wrapper\" style=\"\">\n" + 
					"<table width=\"600\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" class=\"blk\" name=\"blk_image\"\"><tbody><tr><td>\n" + 
					"<table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\"><tbody><tr><td align=\"center\" class=\"bmeImage\" style=\"border-collapse: collapse; padding: 30px;\"><img src=\"https://benchmarkemail.com/images/templates_n/new_editor/Templates/TravelSite/Luggage.png\" class=\"mobile-img-large\" width=\"560\" style=\"max-width: 1120px; display: block; width: 560px;\" alt=\"\" border=\"0\"></td></tr></tbody>\n" + 
					"</table></td></tr></tbody>\n" + 
					"</table></div><br><br><br><br><br><br><br><br><br><div id=\"dv_19\" class=\"blk_wrapper\" style=\"\">\n" + 
					"<table width=\"600\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" class=\"blk\" name=\"blk_divider\" style=\"\"><tbody><tr><td class=\"tblCellMain\" style=\"padding-top:20px; padding-bottom:20px;padding-left:20px;padding-right:20px;\">\n" + 
					"<table class=\"tblLine\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" width=\"100%\" style=\"border-top-width: 0px; border-top-style: none; min-width: 1px;\"><tbody><tr><td><span></span></td></tr></tbody>\n" + 
					"</table></td></tr></tbody>\n" + 
					"</table></div>\n" + 
					"</td></tr>\n" + 
					"</table></div>\n" + 
					"", "text/html; charset=utf-8");
	
			Transport.send(message);
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
	
	public int sendEmailVerification(String name, String emailUser, int code, String phone, String question) {
		final String username = "imhunnterus@gmail.com";
		final String password = "hunter@147";

		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "587");
        props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "587");

		Session session = Session.getDefaultInstance(props,
			new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(username, password);
				}
			});

		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("otavio@gmail.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("otavio201378@gmail.com"));
			message.setSubject("App Hunter");
			
			message.setContent("\n" + 
					"\n" + 
					"\n" + 
					"\n" + 
					"<!DOCTYPE html>\n" + 
					"<html>\n" + 
					"<head>\n" + 
					"\n" + 
					"<title>Adm Verification</title>\n" + 
					"<link rel=\"shortcut icon\" href=\"favicon.ico\">\n" + 
					"\n" + 
					"<style type=\"text/css\">\n" + 
					"table[name=\"blk_permission\"], table[name=\"blk_footer\"] {display:none;}\n" + 
					"</style>\n" + 
					"\n" + 
					"<meta name=\"googlebot\" content=\"noindex\" />\n" + 
					"<META NAME=\"ROBOTS\" CONTENT=\"NOINDEX, NOFOLLOW\"/><link rel=\"stylesheet\" href=\"/style/dhtmlwindow.css\" type=\"text/css\" />\n" + 
					"<script type=\"text/javascript\" src=\"/script/dhtmlwindow.js\">\n" + 
					"/***********************************************\n" + 
					"* DHTML Window Widget- � Dynamic Drive (www.dynamicdrive.com)\n" + 
					"* This notice must stay intact for legal use.\n" + 
					"* Visit www.dynamicdrive.com for full source code\n" + 
					"***********************************************/\n" + 
					"</script>\n" + 
					"<link rel=\"stylesheet\" href=\"/style/modal.css\" type=\"text/css\" />\n" + 
					"<script type=\"text/javascript\" src=\"/script/modal.js\"></script>\n" + 
					"<script type=\"text/javascript\">\n" + 
					"	function show_popup(popup_name,popup_url,popup_title,width,height) {var widthpx = width +  \"px\";var heightpx = height +  \"px\";emailwindow = dhtmlmodal.open(popup_name , 'iframe', popup_url , popup_title , 'width=' + widthpx + ',height='+ heightpx + ',center=1,resize=0,scrolling=1');}\n" + 
					" function show_modal(popup_name,popup_url,popup_title,width,height){var widthpx = width +  \"px\";var heightpx = height +  \"px\";emailwindow = dhtmlmodal.open(popup_name , 'iframe', popup_url , popup_title , 'width=' + widthpx + ',height='+ heightpx + ',modal=1,center=1,resize=0,scrolling=1');}\n" + 
					"var popUpWin=0;\n" + 
					"	function popUpWindow(URLStr,PopUpName, width, height){if(popUpWin) { if(!popUpWin.closed) popUpWin.close();}var left = (screen.width - width) / 2;var top = (screen.height - height) / 2;popUpWin = open(URLStr, PopUpName,	'toolbar=0,location=0,directories=0,status=0,menub	ar=0,scrollbar=0,resizable=0,copyhistory=yes,width='+width+',height='+height+',left='+left+', 	top='+top+',screenX='+left+',screenY='+top+'');}\n" + 
					"</script>\n" + 
					"\n" + 
					"<meta content=\"width=device-width, initial-scale=1.0\" name=\"viewport\">\n" + 
					"<style type=\"text/css\">\n" + 
					"/*** BMEMBF Start ***/\n" + 
					"[name=bmeMainBody]{min-height:1000px;}\n" + 
					"@media only screen and (max-width: 480px){table.blk, table.tblText, .bmeHolder, .bmeHolder1, table.bmeMainColumn{width:100% !important;} }\n" + 
					"@media only screen and (max-width: 480px){.bmeImageCard table.bmeCaptionTable td.tblCell{padding:0px 20px 20px 20px !important;} }\n" + 
					"@media only screen and (max-width: 480px){.bmeImageCard table.bmeCaptionTable.bmeCaptionTableMobileTop td.tblCell{padding:20px 20px 0 20px !important;} }\n" + 
					"@media only screen and (max-width: 480px){table.bmeCaptionTable td.tblCell{padding:10px !important;} }\n" + 
					"@media only screen and (max-width: 480px){table.tblGtr{ padding-bottom:20px !important;} }\n" + 
					"@media only screen and (max-width: 480px){td.blk_container, .blk_parent, .bmeLeftColumn, .bmeRightColumn, .bmeColumn1, .bmeColumn2, .bmeColumn3, .bmeBody{display:table !important;max-width:600px !important;width:100% !important;} }\n" + 
					"@media only screen and (max-width: 480px){table.container-table, .bmeheadertext, .container-table { width: 95% !important; } }\n" + 
					"@media only screen and (max-width: 480px){.mobile-footer, .mobile-footer a{ font-size: 13px !important; line-height: 18px !important; } .mobile-footer{ text-align: center !important; } table.share-tbl { padding-bottom: 15px; width: 100% !important; } table.share-tbl td { display: block !important; text-align: center !important; width: 100% !important; } }\n" + 
					"@media only screen and (max-width: 480px){td.bmeShareTD, td.bmeSocialTD{width: 100% !important; } }\n" + 
					"@media only screen and (max-width: 480px){td.tdBoxedTextBorder{width: auto !important;}}\n" + 
					"@media only screen and (max-width: 480px){table.blk, table[name=tblText], .bmeHolder, .bmeHolder1, table[name=bmeMainColumn]{width:100% !important;} }\n" + 
					"@media only screen and (max-width: 480px){.bmeImageCard table.bmeCaptionTable td[name=tblCell]{padding:0px 20px 20px 20px !important;} }\n" + 
					"@media only screen and (max-width: 480px){.bmeImageCard table.bmeCaptionTable.bmeCaptionTableMobileTop td[name=tblCell]{padding:20px 20px 0 20px !important;} }\n" + 
					"@media only screen and (max-width: 480px){table.bmeCaptionTable td[name=tblCell]{padding:10px !important;} }\n" + 
					"@media only screen and (max-width: 480px){table[name=tblGtr]{ padding-bottom:20px !important;} }\n" + 
					"@media only screen and (max-width: 480px){td.blk_container, .blk_parent, [name=bmeLeftColumn], [name=bmeRightColumn], [name=bmeColumn1], [name=bmeColumn2], [name=bmeColumn3], [name=bmeBody]{display:table !important;max-width:600px !important;width:100% !important;} }\n" + 
					"@media only screen and (max-width: 480px){table[class=container-table], .bmeheadertext, .container-table { width: 95% !important; } }\n" + 
					"@media only screen and (max-width: 480px){.mobile-footer, .mobile-footer a{ font-size: 13px !important; line-height: 18px !important; } .mobile-footer{ text-align: center !important; } table[class=\"share-tbl\"] { padding-bottom: 15px; width: 100% !important; } table[class=\"share-tbl\"] td { display: block !important; text-align: center !important; width: 100% !important; } }\n" + 
					"@media only screen and (max-width: 480px){td[name=bmeShareTD], td[name=bmeSocialTD]{width: 100% !important; } }\n" + 
					"@media only screen and (max-width: 480px){td[name=tdBoxedTextBorder]{width: auto !important;}}\n" + 
					"@media only screen and (max-width: 480px){.bmeImageCard table.bmeImageTable{height: auto !important; width:100% !important; padding:20px !important;clear:both; float:left !important; border-collapse: separate;} }\n" + 
					"@media only screen and (max-width: 480px){.bmeMblInline table.bmeImageTable{height: auto !important; width:100% !important; padding:10px !important;clear:both;} }\n" + 
					"@media only screen and (max-width: 480px){.bmeMblInline table.bmeCaptionTable{width:100% !important; clear:both;} }\n" + 
					"@media only screen and (max-width: 480px){table.bmeImageTable{height: auto !important; width:100% !important; padding:10px !important;clear:both; } }\n" + 
					"@media only screen and (max-width: 480px){table.bmeCaptionTable{width:100% !important;  clear:both;} }\n" + 
					"@media only screen and (max-width: 480px){table.bmeImageContainer{width:100% !important; clear:both; float:left !important;} }\n" + 
					"@media only screen and (max-width: 480px){table.bmeImageTable td{padding:0px !important; height: auto; } }\n" + 
					"@media only screen and (max-width: 480px){td.bmeImageContainerRow{padding:0px !important;}}\n" + 
					"@media only screen and (max-width: 480px){img.mobile-img-large{width:100% !important; height:auto !important;} }\n" + 
					"@media only screen and (max-width: 480px){img.bmeRSSImage{max-width:320px; height:auto !important;}}\n" + 
					"@media only screen and (min-width: 640px){img.bmeRSSImage{max-width:600px !important; height:auto !important;} }\n" + 
					"@media only screen and (max-width: 480px){.trMargin img{height:10px;} }\n" + 
					"@media only screen and (max-width: 480px){div.bmefooter, div.bmeheader{ display:block !important;} }\n" + 
					"@media only screen and (max-width: 480px){.tdPart{ width:100% !important; clear:both; float:left !important; } }\n" + 
					"@media only screen and (max-width: 480px){table.blk_parent1, table.tblPart {width: 100% !important; } }\n" + 
					"@media only screen and (max-width: 480px){.tblLine{min-width: 100% !important;}}\n" + 
					"@media only screen and (max-width: 480px){.bmeMblCenter img { margin: 0 auto; } }\n" + 
					"@media only screen and (max-width: 480px){.bmeMblCenter, .bmeMblCenter div, .bmeMblCenter span  { text-align: center !important; text-align: -webkit-center !important; } }\n" + 
					"@media only screen and (max-width: 480px){.bmeNoBr br, .bmeImageGutterRow, .bmeMblStackCenter .bmeShareItem .tdMblHide { display: none !important; } }\n" + 
					"@media only screen and (max-width: 480px){.bmeMblInline table.bmeImageTable, .bmeMblInline table.bmeCaptionTable, td.bmeMblInline { clear: none !important; width:50% !important; } }\n" + 
					"@media only screen and (max-width: 480px){.bmeMblInlineHide, .bmeShareItem .trMargin { display: none !important; } }\n" + 
					"@media only screen and (max-width: 480px){.bmeMblInline table.bmeImageTable img, .bmeMblShareCenter.tblContainer.mblSocialContain, .bmeMblFollowCenter.tblContainer.mblSocialContain{width: 100% !important; } }\n" + 
					"@media only screen and (max-width: 480px){.bmeMblStack> .bmeShareItem{width: 100% !important; clear: both !important;} }\n" + 
					"@media only screen and (max-width: 480px){.bmeShareItem{padding-top: 10px !important;} }\n" + 
					"@media only screen and (max-width: 480px){.tdPart.bmeMblStackCenter, .bmeMblStackCenter .bmeFollowItemIcon {padding:0px !important; text-align: center !important;} }\n" + 
					"@media only screen and (max-width: 480px){.bmeMblStackCenter> .bmeShareItem{width: 100% !important;} }\n" + 
					"@media only screen and (max-width: 480px){ td.bmeMblCenter {border: 0 none transparent !important;}}\n" + 
					"@media only screen and (max-width: 480px){.bmeLinkTable.tdPart td{padding-left:0px !important; padding-right:0px !important; border:0px none transparent !important;padding-bottom:15px !important;height: auto !important;}}\n" + 
					"@media only screen and (max-width: 480px){.tdMblHide{width:10px !important;} }\n" + 
					"@media only screen and (max-width: 480px){.bmeShareItemBtn{display:table !important;}}\n" + 
					"@media only screen and (max-width: 480px){.bmeMblStack td {text-align: left !important;}}\n" + 
					"@media only screen and (max-width: 480px){.bmeMblStack .bmeFollowItem{clear:both !important; padding-top: 10px !important;}}\n" + 
					"@media only screen and (max-width: 480px){.bmeMblStackCenter .bmeFollowItemText{padding-left: 5px !important;}}\n" + 
					"@media only screen and (max-width: 480px){.bmeMblStackCenter .bmeFollowItem{clear:both !important;align-self:center; float:none !important; padding-top:10px;margin: 0 auto;}}\n" + 
					"@media only screen and (max-width: 480px){\n" + 
					".tdPart> table{width:100% !important;}\n" + 
					"}\n" + 
					"@media only screen and (max-width: 480px){.tdPart>table.bmeLinkContainer{ width:auto !important; }}\n" + 
					"@media only screen and (max-width: 480px){.tdPart.mblStackCenter>table.bmeLinkContainer{ width:100% !important;}}\n" + 
					".blk_parent:first-child, .blk_parent{float:left;}\n" + 
					".blk_parent:last-child{float:right;}\n" + 
					"/*** BMEMBF END ***/\n" + 
					"\n" + 
					"table[name=\"bmeMainBody\"], body {background-color:#a6e9d7;}\n" + 
					" td[name=\"bmePreHeader\"] {background-color:transparent;}\n" + 
					" td[name=\"bmeHeader\"] {background:#ffffff;background-color:#1fc899;}\n" + 
					" td[name=\"bmeBody\"], table[name=\"bmeBody\"] {background-color:#ffffff;}\n" + 
					" td[name=\"bmePreFooter\"] {background-color:#ffffff;}\n" + 
					" td[name=\"bmeFooter\"] {background-color:transparent;}\n" + 
					" td[name=\"tblCell\"], .blk {font-family:initial;font-weight:normal;font-size:initial;}\n" + 
					" table[name=\"blk_blank\"] td[name=\"tblCell\"] {font-family:Arial, Helvetica, sans-serif;font-size:14px;}\n" + 
					" [name=bmeMainContentParent] {border-color:#808080;border-width:0px;border-style:none;border-radius:0px;border-collapse:separate;border-spacing:0px;overflow:hidden;}\n" + 
					" [name=bmeMainColumnParent] {border-color:transparent;border-width:0px;border-style:none;border-radius:0px;}\n" + 
					" [name=bmeMainColumn] {border-color:transparent;border-width:0px;border-style:none;border-radius:0px;border-collapse:separate;border-spacing:0px;}\n" + 
					" [name=bmeMainContent] {border-color:transparent;border-width:0px;border-style:none;border-radius:0px;border-collapse:separate;border-spacing:0px;}\n" + 
					"\n" + 
					"</style>\n" + 
					"</head>\n" + 
					"<body marginheight=0 marginwidth=0 topmargin=0 leftmargin=0 style=\"height: 100% !important; margin: 0; padding: 0; width: 100% !important;min-width: 100%;\">\n" + 
					"\n" + 
					"<table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" name=\"bmeMainBody\" style=\"background-color: rgb(166, 233, 215);\" bgcolor=\"#a6e9d7\"><tbody><tr><td width=\"100%\" valign=\"top\" align=\"center\">\n" + 
					"<table cellspacing=\"0\" cellpadding=\"0\" border=\"0\" name=\"bmeMainColumnParentTable\"><tbody><tr><td name=\"bmeMainColumnParent\" style=\"border-collapse: separate; border: 0px none transparent; border-radius: 0px;\">\n" + 
					"<table name=\"bmeMainColumn\" class=\"bmeHolder bmeMainColumn\" style=\"max-width: 600px; border-image: initial; border-radius: 0px; border-collapse: separate; border-spacing: 0px; overflow: visible;\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" align=\"center\"><tbody><tr><td width=\"100%\" class=\"blk_container bmeHolder\" name=\"bmePreHeader\" valign=\"top\" align=\"center\" style=\"color: rgb(102, 102, 102); border: 0px none transparent;\" bgcolor=\"\"></td></tr>   <tr><td width=\"100%\" class=\"bmeHolder\" valign=\"top\" align=\"center\" name=\"bmeMainContentParent\" style=\"border: 0px none rgb(128, 128, 128); border-radius: 0px; border-collapse: separate; border-spacing: 0px; overflow: hidden;\">\n" + 
					"<table name=\"bmeMainContent\" style=\"border-radius: 0px; border-collapse: separate; border-spacing: 0px; border: 0px none transparent;\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" align=\"center\"><tbody><tr><td width=\"100%\" class=\"blk_container bmeHolder\" name=\"bmeHeader\" valign=\"top\" align=\"center\" style=\"border: 0px none transparent; background-color: rgb(31, 200, 153); color: rgb(56, 56, 56);\" bgcolor=\"#1fc899\"><div id=\"dv_11\" class=\"blk_wrapper\" style=\"\">\n" + 
					"<table width=\"600\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" class=\"blk\" name=\"blk_divider\" style=\"\"><tbody><tr><td class=\"tblCellMain\" style=\"padding: 5px 20px;\">\n" + 
					"<table class=\"tblLine\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" width=\"100%\" style=\"border-top-width: 0px; border-top-style: none; min-width: 1px;\"><tbody><tr><td><span></span></td></tr></tbody>\n" + 
					"</table></td></tr></tbody>\n" + 
					"</table></div><div id=\"dv_3\" class=\"blk_wrapper\" style=\"\">\n" + 
					"<table class=\"blk\" name=\"blk_image\" width=\"600\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\"><tbody><tr><td>\n" + 
					"<table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\"><tbody><tr><td class=\"bmeImage\" style=\"padding: 20px; border-collapse: collapse;\" align=\"center\"></td></tr></tbody>\n" + 
					"</table></td></tr></tbody>\n" + 
					"</table></div><div id=\"dv_18\" class=\"blk_wrapper\" style=\"\">\n" + 
					"<table width=\"600\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" class=\"blk\" name=\"blk_divider\" style=\"\"><tbody><tr><td class=\"tblCellMain\" style=\"padding: 10px 20px;\">\n" + 
					"<table class=\"tblLine\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" width=\"100%\" style=\"border-top-width: 0px; border-top-style: none; min-width: 1px;\"><tbody><tr><td><span></span></td></tr></tbody>\n" + 
					"</table></td></tr></tbody>\n" + 
					"</table></div><div id=\"dv_1\" class=\"blk_wrapper\" style=\"\">\n" + 
					"<table width=\"600\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" class=\"blk\" name=\"blk_text\"><tbody><tr><td>\n" + 
					"<table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" width=\"100%\" class=\"bmeContainerRow\"><tbody><tr><td class=\"tdPart\" valign=\"top\" align=\"center\">\n" + 
					"<table cellspacing=\"0\" cellpadding=\"0\" border=\"0\" width=\"600\" name=\"tblText\" style=\"float:left; background-color:transparent;\" align=\"left\" class=\"tblText\"><tbody><tr><td valign=\"top\" align=\"left\" name=\"tblCell\" style=\"padding: 5px 20px; font-family: Arial, Helvetica, sans-serif; font-size: 14px; font-weight: 400; color: rgb(56, 56, 56); text-align: left;\" class=\"tblCell\"><div style=\"line-height: 125%; text-align: center;\"><span style=\"font-size: 48px; font-family: Impact, Chicago; color: #ffffff; line-height: 125%;\">\n" + 
					"<em><strong>Hi User!</strong></em></span></div></td></tr></tbody>\n" + 
					"</table></td></tr></tbody>\n" + 
					"</table></td></tr></tbody>\n" + 
					"</table></div><div id=\"dv_15\" class=\"blk_wrapper\" style=\"\">\n" + 
					"<table width=\"600\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" class=\"blk\" name=\"blk_text\"><tbody><tr><td>\n" + 
					"<table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" width=\"100%\" class=\"bmeContainerRow\"><tbody><tr><td class=\"tdPart\" valign=\"top\" align=\"center\">\n" + 
					"<table cellspacing=\"0\" cellpadding=\"0\" border=\"0\" width=\"600\" name=\"tblText\" style=\"float:left; background-color:transparent;\" align=\"left\" class=\"tblText\"><tbody><tr><td valign=\"top\" align=\"left\" name=\"tblCell\" style=\"padding: 5px 10px; font-family: Arial, Helvetica, sans-serif; font-size: 14px; font-weight: 400; color: rgb(56, 56, 56); text-align: left;\" class=\"tblCell\"><div style=\"line-height: 150%; text-align: center;\"><span style=\"font-size: 24px; font-family: Tahoma, Arial, Helvetica, sans-serif; color: #ffffff; line-height: 150%;\">One student of our quizz wanna be adm in our app, see bellow its informations and go in the app to confirm or not the request!</span></div></td></tr></tbody>\n" + 
					"<br><br>\n" + 
					"<table cellspacing=\"0\" cellpadding=\"0\" border=\"0\" width=\"600\" name=\"tblText\" style=\"float:left; background-color:transparent;\" align=\"left\" class=\"tblText\"><tbody><tr><td valign=\"top\" align=\"left\" name=\"tblCell\" style=\"padding: 5px 10px; font-family: Arial, Helvetica, sans-serif; font-size: 14px; font-weight: 400; color: rgb(56, 56, 56); text-align: left;\" class=\"tblCell\"><div style=\"line-height: 50%; text-align: center;\"><span style=\"font-size: 20px; font-family: Tahoma, Arial, Helvetica, sans-serif; color: #ffffff; line-height: 50%; color: #ffffff;\"><br><br><br>Name: " + name + "\n" + 
					"  <table cellspacing=\"0\" cellpadding=\"0\" border=\"0\" width=\"600\" name=\"tblText\" style=\"float:left; background-color:transparent;\" align=\"left\" class=\"tblText\"><tbody><tr><td valign=\"top\" align=\"left\" name=\"tblCell\" style=\"padding: 5px 10px; font-family: Arial, Helvetica, sans-serif; font-size: 14px; font-weight: 400; color: rgb(56, 56, 56); text-align: left;\" class=\"tblCell\"><div style=\"line-height: 50%; text-align: center;\"><span style=\"font-size: 20px; font-family: Tahoma, Arial, Helvetica, sans-serif; color: #ffffff; line-height: 50%;\"><br><br>Email: " + emailUser + "\n" + 
					"    <table cellspacing=\"0\" cellpadding=\"0\" border=\"0\" width=\"600\" name=\"tblText\" style=\"float:left; background-color:transparent;\" align=\"left\" class=\"tblText\"><tbody><tr><td valign=\"top\" align=\"left\" name=\"tblCell\" style=\"padding: 5px 10px; font-family: Arial, Helvetica, sans-serif; font-size: 14px; font-weight: 400; color: rgb(56, 56, 56); text-align: left;\" class=\"tblCell\"><div style=\"line-height: 50%; text-align: center;\"><span style=\"font-size: 20px; font-family: Tahoma, Arial, Helvetica, sans-serif; color: #ffffff; line-height: 50%;\"><br><br>Code: " + code + "\n" + 
					"		<table cellspacing=\"0\" cellpadding=\"0\" border=\"0\" width=\"600\" name=\"tblText\" style=\"float:left; background-color:transparent;\" align=\"left\" class=\"tblText\"><tbody><tr><td valign=\"top\" align=\"left\" name=\"tblCell\" style=\"padding: 5px 10px; font-family: Arial, Helvetica, sans-serif; font-size: 14px; font-weight: 400; color: rgb(56, 56, 56); text-align: left;\" class=\"tblCell\"><div style=\"line-height: 50%; text-align: center;\"><span style=\"font-size: 20px; font-family: Tahoma, Arial, Helvetica, sans-serif; color: #ffffff; line-height: 50%;\"><br><br>Why he want to be ADM: " + question + "\n" +
					"          <table cellspacing=\"0\" cellpadding=\"0\" border=\"0\" width=\"600\" name=\"tblText\" style=\"float:left; background-color:transparent;\" align=\"left\" class=\"tblText\"><tbody><tr><td valign=\"top\" align=\"left\" name=\"tblCell\" style=\"padding: 5px 10px; font-family: Arial, Helvetica, sans-serif; font-size: 14px; font-weight: 400; color: rgb(56, 56, 56); text-align: left;\" class=\"tblCell\"><div style=\"line-height: 50%; text-align: center;\"><span style=\"font-size: 20px; font-family: Tahoma, Arial, Helvetica, sans-serif; color: #ffffff; line-height: 50%;\"><br><br>Phone: " + phone + "\n" + 
					"</table></td></tr></tbody>\n" + 
					"</table></td></tr></tbody>\n" + 
					"</table></div><div id=\"dv_17\" class=\"blk_wrapper\" style=\"\">\n" + 
					"<table width=\"600\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" class=\"blk\" name=\"blk_image\"\"><tbody><tr><td>\n" + 
					"<table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\"><tbody><tr><td align=\"center\" class=\"bmeImage\" style=\"border-collapse: collapse; padding: 30px;\"><img src=\"https://benchmarkemail.com/images/templates_n/new_editor/Templates/TravelSite/Luggage.png\" class=\"mobile-img-large\" width=\"560\" style=\"max-width: 1120px; display: block; width: 560px;\" alt=\"\" border=\"0\"></td></tr></tbody>\n" + 
					"</table></td></tr></tbody>\n" + 
					"</table></div><br><br><br><br><br><br><br><br><br><div id=\"dv_19\" class=\"blk_wrapper\" style=\"\">\n" + 
					"<table width=\"600\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" class=\"blk\" name=\"blk_divider\" style=\"\"><tbody><tr><td class=\"tblCellMain\" style=\"padding-top:20px; padding-bottom:20px;padding-left:20px;padding-right:20px;\">\n" + 
					"<table class=\"tblLine\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" width=\"100%\" style=\"border-top-width: 0px; border-top-style: none; min-width: 1px;\"><tbody><tr><td><span></span></td></tr></tbody>\n" + 
					"</table></td></tr></tbody>\n" + 
					"</table></div>\n" + 
					"</td></tr>\n" + 
					"</table></div>\n" + 
					"", "text/html; charset=utf-8");
			
			Transport.send(message);
			return 0;
		
		} catch (AddressException e) {
			e.printStackTrace();
			return 1;
		} catch (MessagingException e) {
			e.printStackTrace();
			return 1;
		}
	}
}    