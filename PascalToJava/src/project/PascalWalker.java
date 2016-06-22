package project;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import project.PascalParser.ActualParameterContext;
import project.PascalParser.ArrayTypeContext;
import project.PascalParser.AssignmentStatementContext;
import project.PascalParser.BaseTypeContext;
import project.PascalParser.BlockContext;
import project.PascalParser.CaseListElementContext;
import project.PascalParser.CaseStatementContext;
import project.PascalParser.ComponentTypeContext;
import project.PascalParser.CompoundStatementContext;
import project.PascalParser.ConditionalStatementContext;
import project.PascalParser.ConstListContext;
import project.PascalParser.ConstantChrContext;
import project.PascalParser.ConstantContext;
import project.PascalParser.ConstantDefinitionContext;
import project.PascalParser.ConstantDefinitionPartContext;
import project.PascalParser.ElementContext;
import project.PascalParser.ElementListContext;
import project.PascalParser.EmptyContext;
import project.PascalParser.EmptyStatementContext;
import project.PascalParser.ExpressionContext;
import project.PascalParser.FactorContext;
import project.PascalParser.FieldListContext;
import project.PascalParser.FileTypeContext;
import project.PascalParser.FinalValueContext;
import project.PascalParser.FixedPartContext;
import project.PascalParser.ForListContext;
import project.PascalParser.ForStatementContext;
import project.PascalParser.FormalParameterListContext;
import project.PascalParser.FormalParameterSectionContext;
import project.PascalParser.FunctionDeclarationContext;
import project.PascalParser.FunctionDesignatorContext;
import project.PascalParser.FunctionTypeContext;
import project.PascalParser.GotoStatementContext;
import project.PascalParser.IdentifierContext;
import project.PascalParser.IdentifierListContext;
import project.PascalParser.IfStatementContext;
import project.PascalParser.IndexTypeContext;
import project.PascalParser.InitialValueContext;
import project.PascalParser.LabelContext;
import project.PascalParser.LabelDeclarationPartContext;
import project.PascalParser.ParameterGroupContext;
import project.PascalParser.ParameterListContext;
import project.PascalParser.PointerTypeContext;
import project.PascalParser.ProcedureAndFunctionDeclarationPartContext;
import project.PascalParser.ProcedureDeclarationContext;
import project.PascalParser.ProcedureOrFunctionDeclarationContext;
import project.PascalParser.ProcedureStatementContext;
import project.PascalParser.ProcedureTypeContext;
import project.PascalParser.ProgramContext;
import project.PascalParser.ProgramHeadingContext;
import project.PascalParser.RecordSectionContext;
import project.PascalParser.RecordTypeContext;
import project.PascalParser.RecordVariableListContext;
import project.PascalParser.RepeatStatementContext;
import project.PascalParser.RepetetiveStatementContext;
import project.PascalParser.ResultTypeContext;
import project.PascalParser.ScalarTypeContext;
import project.PascalParser.SetContext;
import project.PascalParser.SetTypeContext;
import project.PascalParser.SignContext;
import project.PascalParser.SignedFactorContext;
import project.PascalParser.SimpleExpressionContext;
import project.PascalParser.SimpleStatementContext;
import project.PascalParser.SimpleTypeContext;
import project.PascalParser.StatementContext;
import project.PascalParser.StatementsContext;
import project.PascalParser.StringContext;
import project.PascalParser.StringtypeContext;
import project.PascalParser.StructuredStatementContext;
import project.PascalParser.StructuredTypeContext;
import project.PascalParser.SubrangeTypeContext;
import project.PascalParser.TagContext;
import project.PascalParser.TermContext;
import project.PascalParser.TypeContext;
import project.PascalParser.TypeDefinitionContext;
import project.PascalParser.TypeDefinitionPartContext;
import project.PascalParser.TypeIdentifierContext;
import project.PascalParser.TypeListContext;
import project.PascalParser.UnlabelledStatementContext;
import project.PascalParser.UnpackedStructuredTypeContext;
import project.PascalParser.UnsignedConstantContext;
import project.PascalParser.UnsignedIntegerContext;
import project.PascalParser.UnsignedNumberContext;
import project.PascalParser.UnsignedRealContext;
import project.PascalParser.UsesUnitsPartContext;
import project.PascalParser.VariableContext;
import project.PascalParser.VariableDeclarationContext;
import project.PascalParser.VariableDeclarationPartContext;
import project.PascalParser.VariantContext;
import project.PascalParser.VariantPartContext;
import project.PascalParser.WhileStatementContext;
import project.PascalParser.WithStatementContext;

public class PascalWalker extends PascalBaseListener{
   public String translatedSource = "";
   public String newline = System.getProperty("line.separator");
   public static boolean addOnNextExp = false;
   public String cont = "";
   public boolean FirstTimeIdentifier = true;



	@Override
   public void enterProgram(ProgramContext ctx) {
      translatedSource += "import java.io.*;" + newline;
      translatedSource += "import java.lang.Math;" + newline;
      translatedSource += "import java.util.*;" + newline;
      translatedSource += "public class ";
      super.enterProgram(ctx);
   }

   @Override
   public void exitProgram(ProgramContext ctx) {
      super.exitProgram(ctx);
      translatedSource += newline + "}";
   }

	@Override
	public void enterProgramHeading(ProgramHeadingContext ctx) {
      super.enterProgramHeading(ctx);
      System.out.println("enterProgramHeading" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void exitProgramHeading(ProgramHeadingContext ctx) {
		// TODO Auto-generated method stub
		super.exitProgramHeading(ctx);
      System.out.println("exitProgramHeading" + " :--> " + ctx.getText()  + newline);
	}

   @Override
   public void enterIdentifier(IdentifierContext ctx) {
      // can be any identifier like int boolean
      super.enterIdentifier(ctx);
      if (FirstTimeIdentifier) {
         translatedSource += ctx.getText() + "{" + newline;
         FirstTimeIdentifier = false;
      }

   }

	@Override
	public void exitIdentifier(IdentifierContext ctx) {
		// TODO Auto-generated method stub
		super.exitIdentifier(ctx);
	   System.out.println("exitIdentifier" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void enterBlock(BlockContext ctx) {
		// TODO Auto-generated method stub
		super.enterBlock(ctx);
	   System.out.println("enterBlock" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void exitBlock(BlockContext ctx) {
		// TODO Auto-generated method stub
		super.exitBlock(ctx);
	   System.out.println("exitBlock" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void enterUsesUnitsPart(UsesUnitsPartContext ctx) {
		// TODO Auto-generated method stub
		super.enterUsesUnitsPart(ctx);
	   System.out.println("enterUsesUnitsPart" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void exitUsesUnitsPart(UsesUnitsPartContext ctx) {
		// TODO Auto-generated method stub
		super.exitUsesUnitsPart(ctx);
	   System.out.println("exitUsesUnitsPart" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void enterLabelDeclarationPart(LabelDeclarationPartContext ctx) {
		// TODO Auto-generated method stub
		super.enterLabelDeclarationPart(ctx);
	   System.out.println("enterLabelDeclarationPart" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void exitLabelDeclarationPart(LabelDeclarationPartContext ctx) {
		// TODO Auto-generated method stub
		super.exitLabelDeclarationPart(ctx);
	   System.out.println("exitLabelDeclarationPart" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void enterLabel(LabelContext ctx) {
		// TODO Auto-generated method stub
		super.enterLabel(ctx);
	   System.out.println("enterLabel" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void exitLabel(LabelContext ctx) {
		// TODO Auto-generated method stub
		super.exitLabel(ctx);
	   System.out.println("exitLabel" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void enterConstantDefinitionPart(ConstantDefinitionPartContext ctx) {
		// TODO Auto-generated method stub
		super.enterConstantDefinitionPart(ctx);
	   System.out.println("enterConstantDefinitionPart" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void exitConstantDefinitionPart(ConstantDefinitionPartContext ctx) {
		// TODO Auto-generated method stub
		super.exitConstantDefinitionPart(ctx);
	   System.out.println("exitConstantDefinitionPart" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void enterConstantDefinition(ConstantDefinitionContext ctx) {
		// TODO Auto-generated method stub
		super.enterConstantDefinition(ctx);
	   System.out.println("enterConstantDefinition" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void exitConstantDefinition(ConstantDefinitionContext ctx) {
		// TODO Auto-generated method stub
		super.exitConstantDefinition(ctx);
	   System.out.println("exitConstantDefinition" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void enterConstantChr(ConstantChrContext ctx) {
		// TODO Auto-generated method stub
		super.enterConstantChr(ctx);
	   System.out.println("enterConstantChr" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void exitConstantChr(ConstantChrContext ctx) {
		// TODO Auto-generated method stub
		super.exitConstantChr(ctx);
	   System.out.println("exitConstantChr" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void enterConstant(ConstantContext ctx) {
		// TODO Auto-generated method stub
		super.enterConstant(ctx);
	   System.out.println("enterConstant" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void exitConstant(ConstantContext ctx) {
		// TODO Auto-generated method stub
		super.exitConstant(ctx);
	   System.out.println("exitConstant" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void enterUnsignedNumber(UnsignedNumberContext ctx) {
		// TODO Auto-generated method stub
		super.enterUnsignedNumber(ctx);
	   System.out.println("enterUnsignedNumber" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void exitUnsignedNumber(UnsignedNumberContext ctx) {
		// TODO Auto-generated method stub
		super.exitUnsignedNumber(ctx);
	   System.out.println("exitUnsignedNumber" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void enterUnsignedInteger(UnsignedIntegerContext ctx) {
		// TODO Auto-generated method stub
		super.enterUnsignedInteger(ctx);
	   System.out.println("enterUnsignedInteger" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void exitUnsignedInteger(UnsignedIntegerContext ctx) {
		// TODO Auto-generated method stub
		super.exitUnsignedInteger(ctx);
	   System.out.println("exitUnsignedInteger" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void enterUnsignedReal(UnsignedRealContext ctx) {
		// TODO Auto-generated method stub
		super.enterUnsignedReal(ctx);
	   System.out.println("enterUnsignedReal" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void exitUnsignedReal(UnsignedRealContext ctx) {
		// TODO Auto-generated method stub
		super.exitUnsignedReal(ctx);
	   System.out.println("exitUnsignedReal" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void enterSign(SignContext ctx) {
		// TODO Auto-generated method stub
		super.enterSign(ctx);
	   System.out.println("enterSign" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void exitSign(SignContext ctx) {
		// TODO Auto-generated method stub
		super.exitSign(ctx);
	   System.out.println("exitSign" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void enterString(StringContext ctx) {
		// TODO Auto-generated method stub
		super.enterString(ctx);
	   System.out.println("enterString" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void exitString(StringContext ctx) {
		// TODO Auto-generated method stub
		super.exitString(ctx);
	   System.out.println("exitString" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void enterTypeDefinitionPart(TypeDefinitionPartContext ctx) {
		// TODO Auto-generated method stub
		super.enterTypeDefinitionPart(ctx);
	   System.out.println("enterTypeDefinitionPart" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void exitTypeDefinitionPart(TypeDefinitionPartContext ctx) {
		// TODO Auto-generated method stub
		super.exitTypeDefinitionPart(ctx);
	   System.out.println("exitTypeDefinitionPart" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void enterTypeDefinition(TypeDefinitionContext ctx) {
		// TODO Auto-generated method stub
		super.enterTypeDefinition(ctx);
	   System.out.println("enterTypeDefinition" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void exitTypeDefinition(TypeDefinitionContext ctx) {
		// TODO Auto-generated method stub
		super.exitTypeDefinition(ctx);
	   System.out.println("exitTypeDefinition" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void enterFunctionType(FunctionTypeContext ctx) {
		// TODO Auto-generated method stub
		super.enterFunctionType(ctx);
	   System.out.println("enterFunctionType" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void exitFunctionType(FunctionTypeContext ctx) {
		// TODO Auto-generated method stub
		super.exitFunctionType(ctx);
	   System.out.println("exitFunctionType" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void enterProcedureType(ProcedureTypeContext ctx) {
		// TODO Auto-generated method stub
		super.enterProcedureType(ctx);
	   System.out.println("enterProcedureType" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void exitProcedureType(ProcedureTypeContext ctx) {
		// TODO Auto-generated method stub
		super.exitProcedureType(ctx);
	   System.out.println("exitProcedureType" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void enterType(TypeContext ctx) {
		// TODO Auto-generated method stub
		super.enterType(ctx);
	   System.out.println("enterType" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void exitType(TypeContext ctx) {
		// TODO Auto-generated method stub
		super.exitType(ctx);
	   System.out.println("exitType" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void enterSimpleType(SimpleTypeContext ctx) {
		// TODO Auto-generated method stub
		
		super.enterSimpleType(ctx);
	   System.out.println("enterSimpleType" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void exitSimpleType(SimpleTypeContext ctx) {
		// TODO Auto-generated method stub
		super.exitSimpleType(ctx);
	   System.out.println("exitSimpleType" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void enterScalarType(ScalarTypeContext ctx) {
		// TODO Auto-generated method stub
		super.enterScalarType(ctx);
	   System.out.println("enterScalarType" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void exitScalarType(ScalarTypeContext ctx) {
		// TODO Auto-generated method stub
		super.exitScalarType(ctx);
	   System.out.println("exitScalarType" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void enterSubrangeType(SubrangeTypeContext ctx) {
		// TODO Auto-generated method stub
		super.enterSubrangeType(ctx);
	   System.out.println("enterSubrangeType" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void exitSubrangeType(SubrangeTypeContext ctx) {
		// TODO Auto-generated method stub
		super.exitSubrangeType(ctx);
	   System.out.println("exitSubrangeType" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void enterTypeIdentifier(TypeIdentifierContext ctx) {
		// TODO Auto-generated method stub
		super.enterTypeIdentifier(ctx);
	   System.out.println("enterTypeIdentifier" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void exitTypeIdentifier(TypeIdentifierContext ctx) {
		// TODO Auto-generated method stub
		super.exitTypeIdentifier(ctx);
	   System.out.println("exitTypeIdentifier" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void enterStructuredType(StructuredTypeContext ctx) {
		// TODO Auto-generated method stub
		super.enterStructuredType(ctx);
	   System.out.println("enterStructuredType" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void exitStructuredType(StructuredTypeContext ctx) {
		// TODO Auto-generated method stub
		super.exitStructuredType(ctx);
	   System.out.println("exitStructuredType" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void enterUnpackedStructuredType(UnpackedStructuredTypeContext ctx) {
		// TODO Auto-generated method stub
		super.enterUnpackedStructuredType(ctx);
	   System.out.println("enterUnpackedStructuredType" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void exitUnpackedStructuredType(UnpackedStructuredTypeContext ctx) {
		// TODO Auto-generated method stub
		super.exitUnpackedStructuredType(ctx);
	   System.out.println("exitUnpackedStructuredType" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void enterStringtype(StringtypeContext ctx) {
		// TODO Auto-generated method stub
		super.enterStringtype(ctx);
	   System.out.println("enterStringtype" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void exitStringtype(StringtypeContext ctx) {
		// TODO Auto-generated method stub
		super.exitStringtype(ctx);
	   System.out.println("exitStringtype" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void enterArrayType(ArrayTypeContext ctx) {
		// TODO Auto-generated method stub
		super.enterArrayType(ctx);
	   System.out.println("enterArrayType" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void exitArrayType(ArrayTypeContext ctx) {
		// TODO Auto-generated method stub
		super.exitArrayType(ctx);
	   System.out.println("exitArrayType" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void enterTypeList(TypeListContext ctx) {
		// TODO Auto-generated method stub
		super.enterTypeList(ctx);
	   System.out.println("enterTypeList" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void exitTypeList(TypeListContext ctx) {
		// TODO Auto-generated method stub
		super.exitTypeList(ctx);
	   System.out.println("exitTypeList" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void enterIndexType(IndexTypeContext ctx) {
		// TODO Auto-generated method stub
		super.enterIndexType(ctx);
	   System.out.println("enterIndexType" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void exitIndexType(IndexTypeContext ctx) {
		// TODO Auto-generated method stub
		super.exitIndexType(ctx);
	   System.out.println("exitIndexType" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void enterComponentType(ComponentTypeContext ctx) {
		// TODO Auto-generated method stub
		super.enterComponentType(ctx);
	   System.out.println("enterComponentType" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void exitComponentType(ComponentTypeContext ctx) {
		// TODO Auto-generated method stub
		super.exitComponentType(ctx);
	   System.out.println("exitComponentType" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void enterRecordType(RecordTypeContext ctx) {
		// TODO Auto-generated method stub
		super.enterRecordType(ctx);
	   System.out.println("enterRecordType" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void exitRecordType(RecordTypeContext ctx) {
		// TODO Auto-generated method stub
		super.exitRecordType(ctx);
	   System.out.println("exitRecordType" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void enterFieldList(FieldListContext ctx) {
		// TODO Auto-generated method stub
		super.enterFieldList(ctx);
	   System.out.println("enterFieldList" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void exitFieldList(FieldListContext ctx) {
		// TODO Auto-generated method stub
		super.exitFieldList(ctx);
	   System.out.println("exitFieldList" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void enterFixedPart(FixedPartContext ctx) {
		// TODO Auto-generated method stub
		super.enterFixedPart(ctx);
	   System.out.println("enterFixedPart" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void exitFixedPart(FixedPartContext ctx) {
		// TODO Auto-generated method stub
		super.exitFixedPart(ctx);
	   System.out.println("exitFixedPart" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void enterRecordSection(RecordSectionContext ctx) {
		// TODO Auto-generated method stub
		super.enterRecordSection(ctx);
	   System.out.println("enterRecordSection" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void exitRecordSection(RecordSectionContext ctx) {
		// TODO Auto-generated method stub
		super.exitRecordSection(ctx);
	   System.out.println("exitRecordSection" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void enterVariantPart(VariantPartContext ctx) {
		// TODO Auto-generated method stub
		super.enterVariantPart(ctx);
	   System.out.println("exitVariantPart" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void exitVariantPart(VariantPartContext ctx) {
		// TODO Auto-generated method stub
		super.exitVariantPart(ctx);
	   System.out.println("exitVariantPart" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void enterTag(TagContext ctx) {
		// TODO Auto-generated method stub
		super.enterTag(ctx);
	   System.out.println("exitTag" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void exitTag(TagContext ctx) {
		// TODO Auto-generated method stub
		super.exitTag(ctx);
	   System.out.println("exitTag" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void enterVariant(VariantContext ctx) {
		// TODO Auto-generated method stub
		super.enterVariant(ctx);
	   System.out.println("enterVariant" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void exitVariant(VariantContext ctx) {
		// TODO Auto-generated method stub
		super.exitVariant(ctx);
	   System.out.println("exitVariant" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void enterSetType(SetTypeContext ctx) {
		// TODO Auto-generated method stub
		super.enterSetType(ctx);
	   System.out.println("enterSetType" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void exitSetType(SetTypeContext ctx) {
		// TODO Auto-generated method stub
		super.exitSetType(ctx);
	   System.out.println("exitSetType" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void enterBaseType(BaseTypeContext ctx) {
		// TODO Auto-generated method stub
		super.enterBaseType(ctx);
	   System.out.println("enterBaseType" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void exitBaseType(BaseTypeContext ctx) {
		// TODO Auto-generated method stub
		super.exitBaseType(ctx);
	   System.out.println("exitBaseType" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void enterFileType(FileTypeContext ctx) {
		// TODO Auto-generated method stub
		super.enterFileType(ctx);
	   System.out.println("enterFileType" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void exitFileType(FileTypeContext ctx) {
		// TODO Auto-generated method stub
		super.exitFileType(ctx);
	   System.out.println("exitFileType" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void enterPointerType(PointerTypeContext ctx) {
		// TODO Auto-generated method stub
		super.enterPointerType(ctx);
	   System.out.println("enterPointerType" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void exitPointerType(PointerTypeContext ctx) {
		// TODO Auto-generated method stub
		super.exitPointerType(ctx);
	   System.out.println("exitPointerType" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void enterVariableDeclarationPart(VariableDeclarationPartContext ctx) {
		// TODO Auto-generated method stub
	   super.enterVariableDeclarationPart(ctx);
	   System.out.println("enterVariableDeclarationPart" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void exitVariableDeclarationPart(VariableDeclarationPartContext ctx) {
		// TODO Auto-generated method stub
		super.exitVariableDeclarationPart(ctx);
	   System.out.println("exitVariableDeclarationPart" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void enterVariableDeclaration(VariableDeclarationContext ctx) {
		// TODO Auto-generated method stub
		super.enterVariableDeclaration(ctx);
	   System.out.println("enterVariableDeclaration" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void exitVariableDeclaration(VariableDeclarationContext ctx) {
		// TODO Auto-generated method stub
		super.exitVariableDeclaration(ctx);
		String array[] = ctx.getText().split(":");
		String varType = array[1].replace("integer", "int");
		translatedSource+="   public " + varType + " " + array[0] +";"  + newline;
	   System.out.println("exitVariableDeclaration" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void enterProcedureAndFunctionDeclarationPart(ProcedureAndFunctionDeclarationPartContext ctx) {
		// TODO Auto-generated method stub
		super.enterProcedureAndFunctionDeclarationPart(ctx);
	   System.out.println("enterProcedureAndFunctionDeclarationPart" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void exitProcedureAndFunctionDeclarationPart(ProcedureAndFunctionDeclarationPartContext ctx) {
		// TODO Auto-generated method stub
		super.exitProcedureAndFunctionDeclarationPart(ctx);
	   System.out.println("exitProcedureAndFunctionDeclarationPart" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void enterProcedureOrFunctionDeclaration(ProcedureOrFunctionDeclarationContext ctx) {
		// TODO Auto-generated method stub
		super.enterProcedureOrFunctionDeclaration(ctx);
	}

	@Override
	public void exitProcedureOrFunctionDeclaration(ProcedureOrFunctionDeclarationContext ctx) {
		// TODO Auto-generated method stub
		super.exitProcedureOrFunctionDeclaration(ctx);
	   System.out.println("exitProcedureOrFunctionDeclaration" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void enterProcedureDeclaration(ProcedureDeclarationContext ctx) {
		// TODO Auto-generated method stub
		super.enterProcedureDeclaration(ctx);
	   System.out.println("enterProcedureDeclaration" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void exitProcedureDeclaration(ProcedureDeclarationContext ctx) {
		// TODO Auto-generated method stub
		super.exitProcedureDeclaration(ctx);
	   System.out.println("exitProcedureDeclaration" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void enterFormalParameterList(FormalParameterListContext ctx) {
		// TODO Auto-generated method stub
		super.enterFormalParameterList(ctx);
	   System.out.println("enterFormalParameterList" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void exitFormalParameterList(FormalParameterListContext ctx) {
		// TODO Auto-generated method stub
		super.exitFormalParameterList(ctx);
	   System.out.println("exitFormalParameterList" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void enterFormalParameterSection(FormalParameterSectionContext ctx) {
		// TODO Auto-generated method stub
		super.enterFormalParameterSection(ctx);
	   System.out.println("enterFormalParameterSection" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void exitFormalParameterSection(FormalParameterSectionContext ctx) {
		// TODO Auto-generated method stub
		super.exitFormalParameterSection(ctx);
	   System.out.println("exitFormalParameterSection" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void enterParameterGroup(ParameterGroupContext ctx) {
		// TODO Auto-generated method stub
		super.enterParameterGroup(ctx);
	   System.out.println("enterParameterGroup" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void exitParameterGroup(ParameterGroupContext ctx) {
		// TODO Auto-generated method stub
		super.exitParameterGroup(ctx);
	   System.out.println("exitParameterGroup" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void enterIdentifierList(IdentifierListContext ctx) {
		// TODO Auto-generated method stub
		super.enterIdentifierList(ctx);
	   System.out.println("enterIdentifierList" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void exitIdentifierList(IdentifierListContext ctx) {
		// TODO Auto-generated method stub
		super.exitIdentifierList(ctx);
	   System.out.println("exitIdentifierList" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void enterConstList(ConstListContext ctx) {
		// TODO Auto-generated method stub
		super.enterConstList(ctx);
	   System.out.println("enterConstList" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void exitConstList(ConstListContext ctx) {
		// TODO Auto-generated method stub
		super.exitConstList(ctx);
	   System.out.println("exitConstList" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void enterFunctionDeclaration(FunctionDeclarationContext ctx) {
		// TODO Auto-generated method stub
		super.enterFunctionDeclaration(ctx);
	   System.out.println("enterFunctionDeclaration" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void exitFunctionDeclaration(FunctionDeclarationContext ctx) {
		// TODO Auto-generated method stub
		super.exitFunctionDeclaration(ctx);
	   System.out.println("exitFunctionDeclaration" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void enterResultType(ResultTypeContext ctx) {
		// TODO Auto-generated method stub
		super.enterResultType(ctx);
	   System.out.println("enterResultType" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void exitResultType(ResultTypeContext ctx) {
		// TODO Auto-generated method stub
		super.exitResultType(ctx);
	   System.out.println("exitResultType" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void enterStatement(StatementContext ctx) {
		// TODO Auto-generated method stub
		super.enterStatement(ctx);
	   System.out.println("enterStatement" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void exitStatement(StatementContext ctx) {
		// TODO Auto-generated method stub
		super.exitStatement(ctx);
	   System.out.println("exitStatement" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void enterUnlabelledStatement(UnlabelledStatementContext ctx) {
		// TODO Auto-generated method stub
		super.enterUnlabelledStatement(ctx);
	   System.out.println("enterUnlabelledStatement" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void exitUnlabelledStatement(UnlabelledStatementContext ctx) {
		// TODO Auto-generated method stub
		super.exitUnlabelledStatement(ctx);
	   System.out.println("exitUnlabelledStatement" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void enterSimpleStatement(SimpleStatementContext ctx) {
		// TODO Auto-generated method stub
		super.enterSimpleStatement(ctx);
	   System.out.println("enterSimpleStatement" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void exitSimpleStatement(SimpleStatementContext ctx) {
		// TODO Auto-generated method stub
		super.exitSimpleStatement(ctx);
	   System.out.println("exitSimpleStatement" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void enterAssignmentStatement(AssignmentStatementContext ctx) {
		// TODO Auto-generated method stub
		super.enterAssignmentStatement(ctx);
	   System.out.println("enterAssignmentStatement" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void exitAssignmentStatement(AssignmentStatementContext ctx) {
		// TODO Auto-generated method stub
		super.exitAssignmentStatement(ctx);
	   System.out.println("exitAssignmentStatement" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void enterVariable(VariableContext ctx) {
		// TODO Auto-generated method stub
		super.enterVariable(ctx);
	   System.out.println("enterVariable" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void exitVariable(VariableContext ctx) {
		// TODO Auto-generated method stub
		super.exitVariable(ctx);
	   System.out.println("exitVariable" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void enterExpression(ExpressionContext ctx) {
		// TODO Auto-generated method stub
		super.enterExpression(ctx);
	   System.out.println("enterExpression" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void exitExpression(ExpressionContext ctx) {
		// TODO Auto-generated method stub
		super.exitExpression(ctx);
	   System.out.println("exitExpression" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void enterSimpleExpression(SimpleExpressionContext ctx) {
		// TODO Auto-generated method stub
		super.enterSimpleExpression(ctx);
	   System.out.println("enterSimpleExpression" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void exitSimpleExpression(SimpleExpressionContext ctx) {
		// TODO Auto-generated method stub
		super.exitSimpleExpression(ctx);
	   System.out.println("exitSimpleExpression" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void enterTerm(TermContext ctx) {
		// TODO Auto-generated method stub
		super.enterTerm(ctx);
	   System.out.println("enterTerm" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void exitTerm(TermContext ctx) {
		// TODO Auto-generated method stub
		super.exitTerm(ctx);
	   System.out.println("exitTerm" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void enterSignedFactor(SignedFactorContext ctx) {
		// TODO Auto-generated method stub
		super.enterSignedFactor(ctx);
	   System.out.println("enterSignedFactor" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void exitSignedFactor(SignedFactorContext ctx) {
		// TODO Auto-generated method stub
		super.exitSignedFactor(ctx);
	   System.out.println("exitSignedFactor" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void enterFactor(FactorContext ctx) {
		// TODO Auto-generated method stub
		super.enterFactor(ctx);
	   System.out.println("enterFactor" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void exitFactor(FactorContext ctx) {
		// TODO Auto-generated method stub
		super.exitFactor(ctx);
	   System.out.println("exitFactor" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void enterUnsignedConstant(UnsignedConstantContext ctx) {
		// TODO Auto-generated method stub
		super.enterUnsignedConstant(ctx);
	   System.out.println("enterUnsignedConstant" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void exitUnsignedConstant(UnsignedConstantContext ctx) {
		// TODO Auto-generated method stub
		super.exitUnsignedConstant(ctx);
	   System.out.println("exitUnsignedConstant" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void enterFunctionDesignator(FunctionDesignatorContext ctx) {
		// TODO Auto-generated method stub
		super.enterFunctionDesignator(ctx);
	   System.out.println("enterFunctionDesignator" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void exitFunctionDesignator(FunctionDesignatorContext ctx) {
		// TODO Auto-generated method stub
		super.exitFunctionDesignator(ctx);
	   System.out.println("exitFunctionDesignator" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void enterParameterList(ParameterListContext ctx) {
		// TODO Auto-generated method stub
		super.enterParameterList(ctx);
	   System.out.println("enterParameterList" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void exitParameterList(ParameterListContext ctx) {
		// TODO Auto-generated method stub
		super.exitParameterList(ctx);
	   System.out.println("exitParameterList" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void enterSet(SetContext ctx) {
		// TODO Auto-generated method stub
		super.enterSet(ctx);
	   System.out.println("enterSet" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void exitSet(SetContext ctx) {
		// TODO Auto-generated method stub
		super.exitSet(ctx);
	   System.out.println("exitSet" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void enterElementList(ElementListContext ctx) {
		// TODO Auto-generated method stub
		super.enterElementList(ctx);
	   System.out.println("enterElementList" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void exitElementList(ElementListContext ctx) {
		// TODO Auto-generated method stub
		super.exitElementList(ctx);
	   System.out.println("exitElementList" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void enterElement(ElementContext ctx) {
		// TODO Auto-generated method stub
		super.enterElement(ctx);
	   System.out.println("enterElement" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void exitElement(ElementContext ctx) {
		// TODO Auto-generated method stub
		super.exitElement(ctx);
	   System.out.println("exitElement" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void enterProcedureStatement(ProcedureStatementContext ctx) {
		// TODO Auto-generated method stub
		super.enterProcedureStatement(ctx);
	   System.out.println("enterProcedureStatement" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void exitProcedureStatement(ProcedureStatementContext ctx) {
		// TODO Auto-generated method stub
		super.exitProcedureStatement(ctx);
	   System.out.println("exitProcedureStatement" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void enterActualParameter(ActualParameterContext ctx) {
		// TODO Auto-generated method stub
		super.enterActualParameter(ctx);
	   System.out.println("enterActualParameter" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void exitActualParameter(ActualParameterContext ctx) {
		// TODO Auto-generated method stub
		super.exitActualParameter(ctx);
	   System.out.println("exitActualParameter" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void enterGotoStatement(GotoStatementContext ctx) {
		// TODO Auto-generated method stub
		super.enterGotoStatement(ctx);
	   System.out.println("enterGotoStatement" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void exitGotoStatement(GotoStatementContext ctx) {
		// TODO Auto-generated method stub
		super.exitGotoStatement(ctx);
	   System.out.println("exitGotoStatement" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void enterEmptyStatement(EmptyStatementContext ctx) {
		// TODO Auto-generated method stub
		super.enterEmptyStatement(ctx);
	   System.out.println("enterEmptyStatement" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void exitEmptyStatement(EmptyStatementContext ctx) {
		// TODO Auto-generated method stub
		super.exitEmptyStatement(ctx);
	   System.out.println("exitEmptyStatement" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void enterEmpty(EmptyContext ctx) {
		// TODO Auto-generated method stub
		super.enterEmpty(ctx);
	   System.out.println("enterEmpty" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void exitEmpty(EmptyContext ctx) {
		// TODO Auto-generated method stub
		super.exitEmpty(ctx);
	   System.out.println("exitEmpty" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void enterStructuredStatement(StructuredStatementContext ctx) {
		// TODO Auto-generated method stub
		super.enterStructuredStatement(ctx);
	   System.out.println("enterStructuredStatement" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void exitStructuredStatement(StructuredStatementContext ctx) {
		// TODO Auto-generated method stub
		super.exitStructuredStatement(ctx);
	   System.out.println("exitStructuredStatement" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void enterCompoundStatement(CompoundStatementContext ctx) {
		// TODO Auto-generated method stub
		super.enterCompoundStatement(ctx);
	   System.out.println("enterCompoundStatement" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void exitCompoundStatement(CompoundStatementContext ctx) {
		// TODO Auto-generated method stub
		super.exitCompoundStatement(ctx);
	   System.out.println("exitCompoundStatement" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void enterStatements(StatementsContext ctx) {
		// TODO Auto-generated method stub
		super.enterStatements(ctx);
	   System.out.println("enterStatements" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void exitStatements(StatementsContext ctx) {
		// TODO Auto-generated method stub
		super.exitStatements(ctx);
	   System.out.println("exitStatements" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void enterConditionalStatement(ConditionalStatementContext ctx) {
		// TODO Auto-generated method stub
		super.enterConditionalStatement(ctx);
	   System.out.println("enterConditionalStatement" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void exitConditionalStatement(ConditionalStatementContext ctx) {
		// TODO Auto-generated method stub
		super.exitConditionalStatement(ctx);
	   System.out.println("exitConditionalStatement" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void enterIfStatement(IfStatementContext ctx) {
		// TODO Auto-generated method stub
		super.enterIfStatement(ctx);
	   System.out.println("enterIfStatement" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void exitIfStatement(IfStatementContext ctx) {
		// TODO Auto-generated method stub
		super.exitIfStatement(ctx);
	   System.out.println("exitIfStatement" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void enterCaseStatement(CaseStatementContext ctx) {
		// TODO Auto-generated method stub
		super.enterCaseStatement(ctx);
	   System.out.println("enterCaseStatement" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void exitCaseStatement(CaseStatementContext ctx) {
		// TODO Auto-generated method stub
		super.exitCaseStatement(ctx);
	   System.out.println("exitCaseStatement" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void enterCaseListElement(CaseListElementContext ctx) {
		// TODO Auto-generated method stub
		super.enterCaseListElement(ctx);
	   System.out.println("enterCaseListElement" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void exitCaseListElement(CaseListElementContext ctx) {
		// TODO Auto-generated method stub
		super.exitCaseListElement(ctx);
	   System.out.println("exitCaseListElement" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void enterRepetetiveStatement(RepetetiveStatementContext ctx) {
		// TODO Auto-generated method stub
		super.enterRepetetiveStatement(ctx);
	   System.out.println("enterRepetetiveStatement" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void exitRepetetiveStatement(RepetetiveStatementContext ctx) {
		// TODO Auto-generated method stub
		super.exitRepetetiveStatement(ctx);
	   System.out.println("exitRepetetiveStatement" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void enterWhileStatement(WhileStatementContext ctx) {
		// TODO Auto-generated method stub
		super.enterWhileStatement(ctx);
	   System.out.println("enterWhileStatement" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void exitWhileStatement(WhileStatementContext ctx) {
		// TODO Auto-generated method stub
		super.exitWhileStatement(ctx);
	   System.out.println("exitWhileStatement" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void enterRepeatStatement(RepeatStatementContext ctx) {
		// TODO Auto-generated method stub
		super.enterRepeatStatement(ctx);
	   System.out.println("enterRepeatStatement" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void exitRepeatStatement(RepeatStatementContext ctx) {
		// TODO Auto-generated method stub
		super.exitRepeatStatement(ctx);
	   System.out.println("exitRepeatStatement" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void enterForStatement(ForStatementContext ctx) {
		// TODO Auto-generated method stub
		super.enterForStatement(ctx);
	   System.out.println("enterForStatement" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void exitForStatement(ForStatementContext ctx) {
		// TODO Auto-generated method stub
		super.exitForStatement(ctx);
	   System.out.println("exitForStatement" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void enterForList(ForListContext ctx) {
		// TODO Auto-generated method stub
		super.enterForList(ctx);
	   System.out.println("enterForList" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void exitForList(ForListContext ctx) {
		// TODO Auto-generated method stub
		super.exitForList(ctx);
	   System.out.println("exitForList" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void enterInitialValue(InitialValueContext ctx) {
		// TODO Auto-generated method stub
		super.enterInitialValue(ctx);
	   System.out.println("enterInitialValue" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void exitInitialValue(InitialValueContext ctx) {
		// TODO Auto-generated method stub
		super.exitInitialValue(ctx);
	   System.out.println("exitInitialValue" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void enterFinalValue(FinalValueContext ctx) {
		// TODO Auto-generated method stub
		super.enterFinalValue(ctx);
	   System.out.println("enterFinalValue" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void exitFinalValue(FinalValueContext ctx) {
		// TODO Auto-generated method stub
		super.exitFinalValue(ctx);
	   System.out.println("exitFinalValue" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void enterWithStatement(WithStatementContext ctx) {
		// TODO Auto-generated method stub
		super.enterWithStatement(ctx);
	   System.out.println("enterWithStatement" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void exitWithStatement(WithStatementContext ctx) {
		// TODO Auto-generated method stub
		super.exitWithStatement(ctx);
	   System.out.println("exitWithStatement" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void enterRecordVariableList(RecordVariableListContext ctx) {
		// TODO Auto-generated method stub
		super.enterRecordVariableList(ctx);
	   System.out.println("enterRecordVariableList" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void exitRecordVariableList(RecordVariableListContext ctx) {
		// TODO Auto-generated method stub
		super.exitRecordVariableList(ctx);
	   System.out.println("exitRecordVariableList" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void enterEveryRule(ParserRuleContext ctx) {
		// TODO Auto-generated method stub
		super.enterEveryRule(ctx);
	   System.out.println("enterEveryRule" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void exitEveryRule(ParserRuleContext ctx) {
		// TODO Auto-generated method stub
		super.exitEveryRule(ctx);
	   System.out.println("exitEveryRule" + " :--> " + ctx.getText()  + newline);
	}

	@Override
	public void visitTerminal(TerminalNode node) {
		// TODO Auto-generated method stub
		super.visitTerminal(node);
	}

	@Override
	public void visitErrorNode(ErrorNode node) {
		// TODO Auto-generated method stub
		super.visitErrorNode(node);
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
		
	}

	@Override
	public boolean equals(Object arg0) {
		// TODO Auto-generated method stub
		return super.equals(arg0);
	}

	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

   /**
    * metodos auxiliares
    */
   public String swapLastSymbol(String str) {
      char[] c = str.toCharArray();
      char lastSymbol = c[c.length - 1];
      c[c.length - 1] = ' ';
      boolean isInWord = false;
      int bs = -1, be = -1;
      for (int i = c.length - 1; i > 0; i--) {
         if (!(c[i] == ' ') && !isInWord) {
            isInWord = true;
            be = i + 1;
         }
         if (c[i] == ' ' && isInWord) {
            bs = i + 1;

            String aux = str.substring(bs, be);
            str = str.substring(0, bs) + lastSymbol + " " + aux + " ";
            return str;

         }
         continue;

      }
      return null;
   }

   public String swapLastTwoSymbol(String str) {
      char[] c = str.toCharArray();
      char[] lastSymbol = { c[c.length - 1], c[c.length - 2] };
      c[c.length - 1] = ' ';
      c[c.length - 2] = ' ';
      boolean isInWord = false;
      int bs = -1, be = -1;
      for (int i = c.length - 1; i > 0; i--) {
         if (!(c[i] == ' ') && !isInWord) {
            isInWord = true;
            be = i + 1;
         }
         if (c[i] == ' ' && isInWord) {
            bs = i + 1;

            String aux = str.substring(bs, be);
            str = str.substring(0, bs) + lastSymbol[0] + lastSymbol[1] + " " + aux + " ";
            return str;

         }
         continue;

      }
      return null;
   }


   void markAddOnNext(String str) {
      cont = str;
      addOnNextExp = true;
   }

   void addOnNext() {
      if (addOnNextExp) {
         addOnNextExp = false;
         translatedSource += cont;
      }
   }
	

}
