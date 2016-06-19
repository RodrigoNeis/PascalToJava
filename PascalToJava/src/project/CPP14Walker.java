package project;


public class CPP14Walker{
}
/*   extends CPP14BaseListener{
}
	public static String translatedSource = "";
	public static String newline = System.getProperty("line.separator");

	*//**
	 * base
	 *//*
	
	@Override
	public void enterSimpletypespecifier(CPP14Parser.SimpletypespecifierContext ctx) {
		super.enterSimpletypespecifier(ctx);
		if(ctx.Unsigned() != null){
			return;
		}
		if(ctx.Int() != null){
			translatedSource += ctx.getText() + " ";
			return;
		}
		if(ctx.Short() != null){
			translatedSource += ctx.getText()+ " ";
			return;
		}	
		if(ctx.Char() != null || ctx.Char16() != null || ctx.Char32() != null || ctx.Wchar() != null){
			translatedSource += "char" + " ";
			return;
		}
		if(ctx.Bool() != null){
			translatedSource += "boolean" + " ";
			return;
		}
		if(ctx.Long() != null){
			translatedSource += ctx.getText()+ " ";
			return;
		}
		if(ctx.Float() != null){
			translatedSource += ctx.getText()+ " ";
			return;
		}
		if(ctx.Double() != null){
			translatedSource += ctx.getText()+ " ";
			return;
		}
		if(ctx.Void() != null){
			translatedSource += ctx.getText()+ " ";
			return;
		}
		
	}
	
	@Override
	public void exitUnqualifiedid(CPP14Parser.UnqualifiedidContext ctx) {
		super.enterUnqualifiedid(ctx);
		translatedSource += ctx.getText()+ " ";
	}
	
	@Override
	public void enterUnaryoperator(CPP14Parser.UnaryoperatorContext ctx) {
		super.enterUnaryoperator(ctx);
		if(ctx.getText() == "&"){
			return;
		}
		else{
			translatedSource += ctx.getText();
		}
	}
	@Override
	public void enterLiteral(CPP14Parser.LiteralContext ctx) {
		// TODO Auto-generated method stub
		super.enterLiteral(ctx);
		translatedSource += ctx.getText()+ " ";
		addOnNext();
		return;
	}
	@Override
	public void exitClassname(CPP14Parser.ClassnameContext ctx) {
		// TODO Auto-generated method stub
		super.exitClassname(ctx);
		translatedSource+= ctx.getText() + " ";
	}

	@Override
	public void enterBraceorequalinitializer(CPP14Parser.BraceorequalinitializerContext ctx) {
		// TODO Auto-generated method stub
		super.enterBraceorequalinitializer(ctx);
		translatedSource += "= ";
	}
	
	 *  expressões aritimeticas
	 
	
	@Override
	public void exitAdditiveexpression(CPP14Parser.AdditiveexpressionContext ctx) {
		super.exitAdditiveexpression(ctx);
		if(ctx.getChildCount()>1){
			//child(0) é a (1) + (2) b  a+b
			translatedSource += ctx.getChild(1);
			translatedSource = swapLastSymbol(translatedSource);
		}
	}

	@Override
	public void exitMultiplicativeexpression(
		CPP14Parser.MultiplicativeexpressionContext ctx) {
		super.exitMultiplicativeexpression(ctx);
		if(ctx.getChildCount()>1){
			translatedSource += ctx.getChild(1);
			translatedSource = swapLastSymbol(translatedSource);
		}
	}
	
	 * expressões logicas 
	 
	
	@Override
	public void exitLogicalandexpression(CPP14Parser.LogicalandexpressionContext ctx) {
		// TODO Auto-generated method stub
		super.exitLogicalandexpression(ctx);
		if(ctx.getChildCount()>1){
			translatedSource += ctx.getChild(1);
			translatedSource = swapLastTwoSymbol(translatedSource);
		};
	}
	
	@Override
	public void exitLogicalorexpression(CPP14Parser.LogicalorexpressionContext ctx) {
		// TODO Auto-generated method stub
		super.exitLogicalorexpression(ctx);
		if(ctx.getChildCount()>1){
			translatedSource += ctx.getChild(1);
			translatedSource = swapLastTwoSymbol(translatedSource);
		}
	}	
	
	 * expressões sortidas
	 
	
	@Override
	public void exitShiftexpression(CPP14Parser.ShiftexpressionContext ctx) {
		// TODO Auto-generated method stub
		super.exitShiftexpression(ctx);
		if(ctx.getChildCount()>1){
			translatedSource += ctx.getChild(1).getText();
			translatedSource = swapLastTwoSymbol(translatedSource);
		}
	}
	@Override
	public void exitEqualityexpression(CPP14Parser.EqualityexpressionContext ctx) {
		// TODO Auto-generated method stub
		super.exitEqualityexpression(ctx);
		if(ctx.getChildCount()>1){
			translatedSource += ctx.getChild(1).getText();
			translatedSource = swapLastTwoSymbol(translatedSource);
		}
	}
	
	@Override
	public void exitRelationalexpression(CPP14Parser.RelationalexpressionContext ctx) {
		// TODO Auto-generated method stub
		super.exitRelationalexpression(ctx);
		if(ctx.getChildCount()>1){
			String op = ctx.getChild(1).getText();
			translatedSource += op;
			if(op.length()==1){
				translatedSource = swapLastSymbol(translatedSource);
			}
			else{
				translatedSource = swapLastTwoSymbol(translatedSource);
			}
			
			
		}
	}
	@Override
	public void enterPostfixexpression(CPP14Parser.PostfixexpressionContext ctx) {
		// TODO Auto-generated method stub
		super.enterPostfixexpression(ctx);
		if(ctx.getChildCount()>1){
			if(ctx.getChild(1).toString().compareTo("[")==0){
				//translatedSource+="[";
			}
		}
	}
	@Override
	public void exitPostfixexpression(CPP14Parser.PostfixexpressionContext ctx) {
		// TODO Auto-generated method stub
		super.exitPostfixexpression(ctx);
		if(ctx.getChildCount()>1){
			if(ctx.getChild(1).toString().compareTo("[")==0){
			translatedSource += "[";
			translatedSource=swapLastSymbol(translatedSource);
			translatedSource += "]" + " ";
		
			}
			else{
				translatedSource= translatedSource.substring(0,translatedSource.length()-1);
				translatedSource+=ctx.getChild(1);
			}
		}
	}
	@Override
	public void exitExpressionstatement(CPP14Parser.ExpressionstatementContext ctx) {
		// TODO Auto-generated method stub
		super.exitExpressionstatement(ctx);
		if(ctx.getChildCount()>1){
			translatedSource+=ctx.getChild(1) + newline;
		}
	}
	
	 * flow control
	 
	@Override
	public void enterSelectionstatement(CPP14Parser.SelectionstatementContext ctx) {
		// TODO Auto-generated method stub
		super.enterSelectionstatement(ctx);
		if(ctx.getChildCount()>1){
			if (ctx.getChild(0).getText() == "switch") {
				translatedSource+= "switch";
			}
		}
	}
	@Override
	public void enterLabeledstatement(CPP14Parser.LabeledstatementContext ctx) {
		// TODO Auto-generated method stub
		super.enterLabeledstatement(ctx);
		if(ctx.getChildCount()>1){
			String temp = ctx.getChild(0).getText();
			if(temp.compareTo("default")==0){
				translatedSource+= ctx.getChild(0) + ":";
			}
			if(temp.compareTo("case")==0){
				translatedSource+= ctx.getChild(0) + " "; 
				markAddOnNext(":");
			}
		}
		
	}
	@Override
	public void exitSelectionstatement(CPP14Parser.SelectionstatementContext ctx) {
		// TODO Auto-generated method stub
		super.exitSelectionstatement(ctx);
		if(ctx.getChildCount()>1){
		}
	}
	
	public void enterCondition(CPP14Parser.ConditionContext ctx) {
		super.enterCondition(ctx);
		if(ctx.getParent().getChildCount()>1){
			translatedSource+= ctx.getParent().getChild(0).getText() + ctx.getParent().getChild(1).getText();
		}
	}
	public void exitCondition(CPP14Parser.ConditionContext ctx) {
		super.exitCondition(ctx);
		if(ctx.getParent().getChildCount()>1){
			translatedSource += ")" ;//+ newline;
		}
	}
	
	

	//statement
	@Override
	public void enterCompoundstatement(CPP14Parser.CompoundstatementContext ctx) {
		// TODO Auto-generated method stub
		super.enterCompoundstatement(ctx);
		if(ctx.getChildCount()>1){
			
			if(ctx.getParent().getParent().getChildCount()>5){
				if(ctx.getParent().getParent().getChild(6).getChild(0).equals(ctx)){//programação orientada a gambiarra
					translatedSource += "else " + ctx.getChild(0).getText() + newline; 
					return;
				}
			}
			//translatedSource += ctx.getChild(0).getText() + newline; 
			translatedSource += "{" + newline; 
		}
	}
	@Override
	public void exitCompoundstatement(CPP14Parser.CompoundstatementContext ctx) {
		// TODO Auto-generated method stub
		super.exitCompoundstatement(ctx);
		if(ctx.getChildCount()>1){
			translatedSource += ctx.getChild(2).getText() + newline; 
		}
	}
	
	@Override
	public void enterExpressionlist(CPP14Parser.ExpressionlistContext ctx) {
		// TODO Auto-generated method stub
		super.enterExpressionlist(ctx);
		if(ctx.parent.getChildCount()>1){
			translatedSource+="(";
		}
	}
	@Override
	public void exitExpressionlist(CPP14Parser.ExpressionlistContext ctx) {
		// TODO Auto-generated method stub
		super.exitExpressionlist(ctx);
		if(ctx.parent.getChildCount()>1){
			translatedSource+= ")";
		}
	}
	
	@Override
	public void enterIterationstatement(CPP14Parser.IterationstatementContext ctx) {
		// TODO Auto-generated method stub
		super.enterIterationstatement(ctx);
		if(ctx.getChildCount()>1){
		//	translatedSource+=  ctx.getChild(0).getText() + ctx.getChild(1).getText();
		}
	}
	@Override
	public void exitIterationstatement(CPP14Parser.IterationstatementContext ctx) {
		// TODO Auto-generated method stub
		super.exitIterationstatement(ctx);
		if(ctx.getChildCount()>1){
			translatedSource+= "";
		}
	}
	
	@Override
	public void enterInitializerclause(CPP14Parser.InitializerclauseContext ctx) {
		// TODO Auto-generated method stub
		super.enterInitializerclause(ctx);
		if(ctx.parent.getChildCount()>2 ){
			if(ctx.parent.getChild(1).getText().compareTo("=")==0){
				translatedSource+= "= ";
			}		
			else{
				translatedSource+= ", ";
			}
		}
	}

	
	 * declarações
	 

	@Override
	public void exitSimpledeclaration(CPP14Parser.SimpledeclarationContext ctx) {
		// TODO Auto-generated method stub
		super.exitSimpledeclaration(ctx);
		translatedSource += ";" + newline;
	}
	
	@Override
	public void exitNoptrdeclarator(CPP14Parser.NoptrdeclaratorContext ctx) {
		// TODO Auto-generated method stub
		super.exitNoptrdeclarator(ctx);
		if(ctx.getChildCount()>2){
			translatedSource += "[";
			translatedSource=swapLastSymbol(translatedSource);
			translatedSource += "]" + " ";
			return;
		}
		
	}
	
	@Override
	public void enterPtrdeclarator(CPP14Parser.PtrdeclaratorContext ctx) {
		// TODO Auto-generated method stub
		super.enterPtrdeclarator(ctx);
		if(ctx.getChildCount()>1){
			translatedSource += "[]" + " ";
		}

	}

	@Override
	public void enterParametersandqualifiers(CPP14Parser.ParametersandqualifiersContext ctx) {
		// TODO Auto-generated method stub
		super.enterParametersandqualifiers(ctx);
		if(ctx.getChildCount()>1){
			translatedSource+= ctx.getChild(0).getText();
		}
	}
	@Override
	public void exitParametersandqualifiers(CPP14Parser.ParametersandqualifiersContext ctx) {
		// TODO Auto-generated method stub
		super.exitParametersandqualifiers(ctx);
		if(ctx.getChildCount()>1){
			translatedSource+= ctx.getChild(2).getText();
		}
	}
	
	@Override
	public void exitParameterdeclarationlist(CPP14Parser.ParameterdeclarationlistContext ctx) {
		// TODO Auto-generated method stub
		super.exitParameterdeclarationlist(ctx);
		if(ctx.getParent().getChildCount()>1){
			translatedSource += ", ";
		}
	}
	
	 
	 * funcs
	 
		
	@Override
	public void enterFunctiondefinition(CPP14Parser.FunctiondefinitionContext ctx) {
		// TODO Auto-generated method stub
		super.enterFunctiondefinition(ctx);
		if(ctx.getParent().getChildCount()>1){
			translatedSource += "public static ";
		}
	}
	
	//returns
	@Override
	public void enterJumpstatement(CPP14Parser.JumpstatementContext ctx) {
		// TODO Auto-generated method stub
		super.enterJumpstatement(ctx);
		translatedSource += ctx.getChild(0) + " ";
	}
	
	@Override
	public void exitJumpstatement(CPP14Parser.JumpstatementContext ctx) {
		// TODO Auto-generated method stub
		super.exitJumpstatement(ctx);
		translatedSource += ";" + newline;
	}
	
	
	*//**
	 * OO
	 *//*
	
	*//**
	 * string
	 *//*
	
	
	//primeira
	
	@Override
	public void enterTranslationunit(CPP14Parser.TranslationunitContext ctx) {
		// TODO Auto-generated method stub
		super.enterTranslationunit(ctx);
		translatedSource+="import java.io.*;" + newline;
		translatedSource+="import java.lang.Math;" + newline;
		translatedSource+="import java.util.*;" + newline;
		translatedSource+= "public class Wrapper{" + newline;
	}
	
	//ultima ação executada
	@Override
	public void exitTranslationunit(CPP14Parser.TranslationunitContext ctx) {
		// TODO Auto-generated method stub
		super.exitTranslationunit(ctx);
		translatedSource+= newline + "}";
		
	}
	
	*//**
	 * metodos auxiliares
	 *//*
	public String swapLastSymbol(String str){
		char[] c = str.toCharArray();
		char lastSymbol =c[c.length-1];
		c[c.length-1] = ' ';
		boolean isInWord = false;
		int bs=-1, be=-1;
		for (int i = c.length-1;i > 0; i--) {
			if(!(c[i]==' ') && !isInWord){
				isInWord = true;
				be = i+1;
			}
			if(c[i] == ' ' && isInWord){
				bs = i+1;
				
				String aux = str.substring(bs, be);
				str = str.substring(0, bs) + lastSymbol + " " + aux + " ";
				return str;
				
			}
			continue;
			
		}
		return null;
	}
	public String swapLastTwoSymbol(String str){
		char[] c = str.toCharArray();
		char[] lastSymbol ={ c[c.length-1], c[c.length-2] } ;
		c[c.length-1] = ' ';
		c[c.length-2] = ' ';
		boolean isInWord = false;
		int bs=-1, be=-1;
		for (int i = c.length-1;i > 0; i--) {
			if(!(c[i]==' ') && !isInWord){
				isInWord = true;
				be = i+1;
			}
			if(c[i] == ' ' && isInWord){
				bs = i+1;
				
				String aux = str.substring(bs, be);
				str = str.substring(0, bs) + lastSymbol[0] + lastSymbol[1] + " " + aux + " ";
				return str;
				
			}
			continue;
			
		}
		return null;
	}
	static boolean addOnNextExp = false;
	static String cont = "";
	void markAddOnNext(String str){
		cont = str;
		addOnNextExp=true;
	}
	void addOnNext(){
		if(addOnNextExp){
			addOnNextExp=false;
			translatedSource += cont;
		}
	}
}*/
