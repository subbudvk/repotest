package parsecsstest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

import com.helger.commons.collection.impl.ICommonsList;
import com.helger.css.ECSSVersion;
import com.helger.css.decl.CSSDeclaration;
import com.helger.css.decl.CSSExpressionMemberTermURI;
import com.helger.css.decl.CSSFontFaceRule;
import com.helger.css.decl.CSSImportRule;
import com.helger.css.decl.CSSSelector;
import com.helger.css.decl.CSSSelectorAttribute;
import com.helger.css.decl.CSSStyleRule;
import com.helger.css.decl.CascadingStyleSheet;
import com.helger.css.decl.ICSSSelectorMember;
import com.helger.css.handler.ICSSParseExceptionCallback;
import com.helger.css.parser.ParseException;
import com.helger.css.reader.CSSReader;

public class Main {
	public static void main(String[] args) {
		
		
		
		ArrayList<String> cssSnippets = new ArrayList<>();


        // Add various complex CSS snippets to the ArrayList
        cssSnippets.add(
            "@import url('https://fonts.googleapis.com/css2?family=Montserrat:wght@300;600&display=swap');" +
            "" +
            "html {" +
            "  font-size: 18px;" +
            "}" +
            "" +
            "body {" +
            "  font-family: 'Montserrat', sans-serif;" +
            "  background: #eaeaea;" +
            "  color: #333;" +
            "  margin: 0;" +
            "  padding: 0;" +
            "  display: flex;" +
            "  flex-direction: column;" +
            "  min-height: 100vh;" +
            "}" +
            "" +
            "header {" +
            "  background: #007bff;" +
            "  color: #fff;" +
            "  padding: 20px;" +
            "  box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);" +
            "  display: flex;" +
            "  justify-content: space-between;" +
            "  align-items: center;" +
            "}" +
            "" +
            "header .logo {" +
            "  font-size: 1.5em;" +
            "  font-weight: 600;" +
            "}" +
            "" +
            "nav ul {" +
            "  list-style: none;" +
            "  padding: 0;" +
            "  display: flex;" +
            "}" +
            "" +
            "nav ul li {" +
            "  margin: 0 15px;" +
            "}" +
            "" +
            "nav ul li a {" +
            "  color: #fff;" +
            "  text-decoration: none;" +
            "  transition: color 0.3s;" +
            "}" +
            "" +
            "nav ul li a:hover {" +
            "  color: #f0f0f0;" +
            "}" +
            "" +
            ".main {" +
            "  flex: 1;" +
            "  padding: 20px;" +
            "}" +
            "" +
            ".grid-container {" +
            "  display: grid;" +
            "  grid-template-columns: repeat(auto-fill, minmax(200px, 1fr));" +
            "  gap: 20px;" +
            "}" +
            "" +
            ".card {" +
            "  background: #fff;" +
            "  border-radius: 10px;" +
            "  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);" +
            "  overflow: hidden;" +
            "  transition: transform 0.3s ease;" +
            "}" +
            "" +
            ".card:hover {" +
            "  transform: scale(1.05);" +
            "}" +
            "" +
            ".card img {" +
            "  width: 100%;" +
            "  height: auto;" +
            "}" +
            "" +
            ".card-content {" +
            "  padding: 15px;" +
            "}" +
            "" +
            ".card-title {" +
            "  font-size: 1.25em;" +
            "  margin: 0;" +
            "}" +
            "" +
            ".card-description {" +
            "  font-size: 1em;" +
            "  color: #666;" +
            "}"
        );

        cssSnippets.add(
            "@keyframes pulse {" +
            "  0% {" +
            "    transform: scale(1);" +
            "    opacity: 1;" +
            "  }" +
            "  50% {" +
            "    transform: scale(1.1);" +
            "    opacity: 0.7;" +
            "  }" +
            "  100% {" +
            "    transform: scale(1);" +
            "    opacity: 1;" +
            "  }" +
            "}" +
            "" +
            ".notification {" +
            "  position: absolute;" +
            "  top: 20px;" +
            "  right: 20px;" +
            "  background: #28a745;" +
            "  color: #fff;" +
            "  padding: 15px;" +
            "  border-radius: 5px;" +
            "  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);" +
            "  animation: pulse 2s infinite;" +
            "  z-index: 1000;" +
            "}" +
            "" +
            ".notification.error {" +
            "  background: #dc3545;" +
            "}" +
            "" +
            ".notification.success {" +
            "  background: #28a745;" +
            "}" +
            "" +
            ".notification.info {" +
            "  background: #17a2b8;" +
            "}"
        );

        cssSnippets.add(
            ".responsive-table {" +
            "  width: 100%;" +
            "  border-collapse: collapse;" +
            "  margin: 20px 0;" +
            "}" +
            "" +
            ".responsive-table thead {" +
            "  background: #333;" +
            "  color: #fff;" +
            "}" +
            "" +
            ".responsive-table th, .responsive-table td {" +
            "  padding: 15px;" +
            "  text-align: left;" +
            "  border-bottom: 1px solid #ddd;" +
            "}" +
            "" +
            ".responsive-table tr:nth-child(even) {" +
            "  background: #f9f9f9;" +
            "}" +
            "" +
            "@media (max-width: 768px) {" +
            "  .responsive-table thead {" +
            "    display: none;" +
            "  }" +
            "" +
            "  .responsive-table, .responsive-table tbody, .responsive-table tr, .responsive-table td {" +
            "    display: block;" +
            "    width: 100%;" +
            "  }" +
            "" +
            "  .responsive-table tr {" +
            "    margin-bottom: 1em;" +
            "    border: 1px solid #ddd;" +
            "  }" +
            "" +
            "  .responsive-table td {" +
            "    text-align: right;" +
            "    position: relative;" +
            "    padding-left: 50%;" +
            "    padding-bottom: 1em;" +
            "    box-sizing: border-box;" +
            "  }" +
            "" +
            "  .responsive-table td::before {" +
            "    content: attr(data-label);" +
            "    position: absolute;" +
            "    left: 0;" +
            "    width: 50%;" +
            "    padding-left: 10px;" +
            "    font-weight: bold;" +
            "    white-space: nowrap;" +
            "    top: 0;" +
            "  }" +
            "}"
        );

        cssSnippets.add(
            ".carousel {" +
            "  position: relative;" +
            "  overflow: hidden;" +
            "}" +
            "" +
            ".carousel .slides {" +
            "  display: flex;" +
            "  transition: transform 0.5s ease-in-out;" +
            "}" +
            "" +
            ".carousel .slide {" +
            "  min-width: 100%;" +
            "  box-sizing: border-box;" +
            "}" +
            "" +
            ".carousel .prev, .carousel .next {" +
            "  position: absolute;" +
            "  top: 50%;" +
            "  width: 40px;" +
            "  height: 40px;" +
            "  background: rgba(0, 0, 0, 0.5);" +
            "  color: #fff;" +
            "  border: none;" +
            "  border-radius: 50%;" +
            "  cursor: pointer;" +
            "  display: flex;" +
            "  align-items: center;" +
            "  justify-content: center;" +
            "  transform: translateY(-50%);" +
            "}" +
            "" +
            ".carousel .prev {" +
            "  left: 10px;" +
            "}" +
            "" +
            ".carousel .next {" +
            "  right: 10px;" +
            "}" +
            "" +
            "@keyframes fadeIn {" +
            "  from {" +
            "    opacity: 0;" +
            "  }" +
            "  to {" +
            "    opacity: 1;" +
            "  }" +
            "}" +
            "" +
            ".carousel .slide img {" +
            "  width: 100%;" +
            "  animation: fadeIn 1s ease-in-out;" +
            "}"
        );

        cssSnippets.add(
            "@media (min-width: 1200px) {" +
            "  .container {" +
            "    max-width: 1140px;" +
            "  }" +
            "}" +
            "" +
            "@media (min-width: 992px) and (max-width: 1199px) {" +
            "  .container {" +
            "    max-width: 960px;" +
            "  }" +
            "}" +
            "" +
            "@media (min-width: 768px) and (max-width: 991px) {" +
            "  .container {" +
            "    max-width: 720px;" +
            "  }" +
            "}" +
            "" +
            "@media (max-width: 767px) {" +
            "  .container {" +
            "    max-width: 100%;" +
            "    padding: 0 15px;" +
            "  }" +
            "}" +
            "" +
            ".card-group {" +
            "  display: flex;" +
            "  flex-wrap: wrap;" +
            "  gap: 20px;" +
            "}" +
            "" +
            ".card-group .card {" +
            "  flex: 1 1 calc(33.333% - 20px);" +
            "  box-sizing: border-box;" +
            "  background: #fff;" +
            "  border-radius: 8px;" +
            "  overflow: hidden;" +
            "  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);" +
            "  transition: transform 0.3s ease;" +
            "}" +
            "" +
            ".card-group .card:hover {" +
            "  transform: scale(1.05);" +
            "}" +
            "" +
            ".card-group .card img {" +
            "  width: 100%;" +
            "  height: auto;" +
            "}" +
            "" +
            ".card-group .card-body {" +
            "  padding: 20px;" +
            "}" +
            "" +
            ".card-group .card-title {" +
            "  font-size: 1.25em;" +
            "  margin: 0;" +
            "}"
        );
        
		String css2 = "body { background-color: #fff; }\n" +
                "div[id] { color: blue; }\n" +
                "span[data-custom|='value'] { background: url('https://google.com') }\n h1[a*='b'] { background: url('https://google.com')}";
		
		
        cssSnippets.add(css2);
		
        String fontFaceCSS = "@font-face {\r\n"
        		+ "  font-family: myFirstFont;\r\n"
        		+ "  src: url('https://testdomain.com/sansation_light.woff');\r\n"
        		+ "}";
        cssSnippets.add(fontFaceCSS);

		for(String css : cssSnippets) {
		CascadingStyleSheet styleSheet = CSSReader.readFromString(css, ECSSVersion.LATEST);
		CSSReader.readFromString(css, ECSSVersion.LATEST);
		
		// @import Rule domains with a property
		ICommonsList<CSSImportRule> importRules = styleSheet.getAllImportRules();
		for(CSSImportRule rule : importRules) {
			System.out.println("Import Rule URI " + rule.getLocation().getURI());
		}
		
		
		//url() property values
		ICommonsList<CSSStyleRule> cssStyleRules = styleSheet.getAllStyleRules();
		for(CSSStyleRule rule : cssStyleRules) {
			ICommonsList<CSSSelector> cssSelectors = rule.getAllSelectors();
			for(CSSSelector selector : cssSelectors) {
				selector.getAllMembers().forEach(selectorMember -> {
						rule.getAllDeclarations().forEach(cssDeclaration -> {
							cssDeclaration.getExpression().getAllMembers().forEach(expressionMember -> {
								if(expressionMember instanceof CSSExpressionMemberTermURI) {
									System.out.println("CSS url() domain value" + ((CSSExpressionMemberTermURI)expressionMember).getURI().getURI());
								}
							});
						});
					
				});
			}
		}
		
		//@font-face Rules
		ICommonsList<CSSFontFaceRule> fontFaceRules = styleSheet.getAllFontFaceRules();
		for(CSSFontFaceRule rule : fontFaceRules) {
			rule.getAllDeclarations().forEach(cssDeclaration -> {
				cssDeclaration.getExpression().getAllMembers().forEach(expressionMember -> {
					if(expressionMember instanceof CSSExpressionMemberTermURI) {
						try {
							System.out.println("fontFace url() domain value" + ((CSSExpressionMemberTermURI)expressionMember).getURI().getURI());
						} catch (URISyntaxException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				});
			});
		}
		
	}
	}
}
	


