// Generated from ContinuityParser.g4 by ANTLR 4.7.1

package com.engineersbox.continuity.instrumenter.lang.antlr;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ContinuityParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		CTX=1, EXT=2, FN=3, STD=4, IF=5, ELSE=6, LET=7, CHAR=8, BOOL=9, INT8=10, 
		INT16=11, INT32=12, INT64=13, FLOAT32=14, FLOAT64=15, STRING=16, OBJECT=17, 
		IntegerLiteral=18, FloatingPointLiteral=19, BooleanLiteral=20, CharacterLiteral=21, 
		StringLiteral=22, NullLiteral=23, LPAREN=24, RPAREN=25, LBRACE=26, RBRACE=27, 
		LBRACK=28, RBRACK=29, SEMI=30, DOT=31, DOLLAR=32, COMMA=33, ARROW=34, 
		ASSIGN=35, GT=36, LT=37, BANG=38, TILDE=39, QUESTION=40, COLON=41, COLONCOLON=42, 
		EQUAL=43, LE=44, GE=45, NOTEQUAL=46, AND=47, OR=48, INC=49, DEC=50, ADD=51, 
		SUB=52, MUL=53, DIV=54, BITAND=55, BITOR=56, CARET=57, MOD=58, Identifier=59, 
		WS=60, COMMENT=61, LINE_COMMENT=62;
	public static final int
		RULE_parse = 0, RULE_statement = 1, RULE_variableDeclaration = 2, RULE_variableType = 3, 
		RULE_arrayType = 4, RULE_arrayLiteral = 5, RULE_variableReference = 6, 
		RULE_arrayIndexer = 7, RULE_externalLayout = 8, RULE_externalEntries = 9, 
		RULE_externalEntryReference = 10, RULE_externalEntryEnumConstantReference = 11, 
		RULE_contextLayout = 12, RULE_contextEntries = 13, RULE_contextEntryReference = 14, 
		RULE_function = 15, RULE_block = 16, RULE_invocation = 17, RULE_methodInvocationChain = 18, 
		RULE_methodInvocation = 19, RULE_params = 20, RULE_param = 21, RULE_reference = 22, 
		RULE_referenceTarget = 23, RULE_referenceChain = 24, RULE_booleanExpresion = 25, 
		RULE_comparisonJoin = 26, RULE_comparator = 27, RULE_valueTarget = 28, 
		RULE_ifCondition = 29, RULE_ifBranch = 30, RULE_elseIfBranch = 31, RULE_elseBranch = 32, 
		RULE_literal = 33;
	public static final String[] ruleNames = {
		"parse", "statement", "variableDeclaration", "variableType", "arrayType", 
		"arrayLiteral", "variableReference", "arrayIndexer", "externalLayout", 
		"externalEntries", "externalEntryReference", "externalEntryEnumConstantReference", 
		"contextLayout", "contextEntries", "contextEntryReference", "function", 
		"block", "invocation", "methodInvocationChain", "methodInvocation", "params", 
		"param", "reference", "referenceTarget", "referenceChain", "booleanExpresion", 
		"comparisonJoin", "comparator", "valueTarget", "ifCondition", "ifBranch", 
		"elseIfBranch", "elseBranch", "literal"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'ctx'", "'ext'", "'fn'", "'std'", "'if'", "'else'", "'let'", "'char'", 
		"'bool'", "'int8'", "'int16'", "'int32'", "'int64'", "'float32'", "'float64'", 
		"'str'", "'Object'", null, null, null, null, null, "'null'", "'('", "')'", 
		"'{'", "'}'", "'['", "']'", "';'", "'.'", "'$'", "','", "'->'", "'='", 
		"'>'", "'<'", "'!'", "'~'", "'?'", "':'", "'::'", "'=='", "'<='", "'>='", 
		"'!='", "'&&'", "'||'", "'++'", "'--'", "'+'", "'-'", "'*'", "'/'", "'&'", 
		"'|'", "'^'", "'%'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "CTX", "EXT", "FN", "STD", "IF", "ELSE", "LET", "CHAR", "BOOL", 
		"INT8", "INT16", "INT32", "INT64", "FLOAT32", "FLOAT64", "STRING", "OBJECT", 
		"IntegerLiteral", "FloatingPointLiteral", "BooleanLiteral", "CharacterLiteral", 
		"StringLiteral", "NullLiteral", "LPAREN", "RPAREN", "LBRACE", "RBRACE", 
		"LBRACK", "RBRACK", "SEMI", "DOT", "DOLLAR", "COMMA", "ARROW", "ASSIGN", 
		"GT", "LT", "BANG", "TILDE", "QUESTION", "COLON", "COLONCOLON", "EQUAL", 
		"LE", "GE", "NOTEQUAL", "AND", "OR", "INC", "DEC", "ADD", "SUB", "MUL", 
		"DIV", "BITAND", "BITOR", "CARET", "MOD", "Identifier", "WS", "COMMENT", 
		"LINE_COMMENT"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "ContinuityParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ContinuityParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ParseContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(ContinuityParser.EOF, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<TerminalNode> SEMI() { return getTokens(ContinuityParser.SEMI); }
		public TerminalNode SEMI(int i) {
			return getToken(ContinuityParser.SEMI, i);
		}
		public ParseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parse; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ContinuityParserListener ) ((ContinuityParserListener)listener).enterParse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ContinuityParserListener ) ((ContinuityParserListener)listener).exitParse(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ContinuityParserVisitor ) return ((ContinuityParserVisitor<? extends T>)visitor).visitParse(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParseContext parse() throws RecognitionException {
		ParseContext _localctx = new ParseContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_parse);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(73);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CTX) | (1L << EXT) | (1L << FN) | (1L << STD) | (1L << IF) | (1L << LET))) != 0)) {
				{
				{
				setState(68);
				statement();
				setState(69);
				match(SEMI);
				}
				}
				setState(75);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(76);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	 
		public StatementContext() { }
		public void copyFrom(StatementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ContextLayoutStatementContext extends StatementContext {
		public ContextLayoutContext contextLayout() {
			return getRuleContext(ContextLayoutContext.class,0);
		}
		public ContextLayoutStatementContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ContinuityParserListener ) ((ContinuityParserListener)listener).enterContextLayoutStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ContinuityParserListener ) ((ContinuityParserListener)listener).exitContextLayoutStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ContinuityParserVisitor ) return ((ContinuityParserVisitor<? extends T>)visitor).visitContextLayoutStatement(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class InvocationStatementContext extends StatementContext {
		public InvocationContext invocation() {
			return getRuleContext(InvocationContext.class,0);
		}
		public InvocationStatementContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ContinuityParserListener ) ((ContinuityParserListener)listener).enterInvocationStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ContinuityParserListener ) ((ContinuityParserListener)listener).exitInvocationStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ContinuityParserVisitor ) return ((ContinuityParserVisitor<? extends T>)visitor).visitInvocationStatement(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FunctionStatementContext extends StatementContext {
		public FunctionContext function() {
			return getRuleContext(FunctionContext.class,0);
		}
		public FunctionStatementContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ContinuityParserListener ) ((ContinuityParserListener)listener).enterFunctionStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ContinuityParserListener ) ((ContinuityParserListener)listener).exitFunctionStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ContinuityParserVisitor ) return ((ContinuityParserVisitor<? extends T>)visitor).visitFunctionStatement(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class VariableDeclarationStatementContext extends StatementContext {
		public VariableDeclarationContext variableDeclaration() {
			return getRuleContext(VariableDeclarationContext.class,0);
		}
		public VariableDeclarationStatementContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ContinuityParserListener ) ((ContinuityParserListener)listener).enterVariableDeclarationStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ContinuityParserListener ) ((ContinuityParserListener)listener).exitVariableDeclarationStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ContinuityParserVisitor ) return ((ContinuityParserVisitor<? extends T>)visitor).visitVariableDeclarationStatement(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IfStatementContext extends StatementContext {
		public IfConditionContext ifCondition() {
			return getRuleContext(IfConditionContext.class,0);
		}
		public IfStatementContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ContinuityParserListener ) ((ContinuityParserListener)listener).enterIfStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ContinuityParserListener ) ((ContinuityParserListener)listener).exitIfStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ContinuityParserVisitor ) return ((ContinuityParserVisitor<? extends T>)visitor).visitIfStatement(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExternalLayoutStatementContext extends StatementContext {
		public ExternalLayoutContext externalLayout() {
			return getRuleContext(ExternalLayoutContext.class,0);
		}
		public ExternalLayoutStatementContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ContinuityParserListener ) ((ContinuityParserListener)listener).enterExternalLayoutStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ContinuityParserListener ) ((ContinuityParserListener)listener).exitExternalLayoutStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ContinuityParserVisitor ) return ((ContinuityParserVisitor<? extends T>)visitor).visitExternalLayoutStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_statement);
		try {
			setState(84);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				_localctx = new FunctionStatementContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(78);
				function();
				}
				break;
			case 2:
				_localctx = new InvocationStatementContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(79);
				invocation();
				}
				break;
			case 3:
				_localctx = new ExternalLayoutStatementContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(80);
				externalLayout();
				}
				break;
			case 4:
				_localctx = new ContextLayoutStatementContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(81);
				contextLayout();
				}
				break;
			case 5:
				_localctx = new IfStatementContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(82);
				ifCondition();
				}
				break;
			case 6:
				_localctx = new VariableDeclarationStatementContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(83);
				variableDeclaration();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariableDeclarationContext extends ParserRuleContext {
		public TerminalNode LET() { return getToken(ContinuityParser.LET, 0); }
		public TerminalNode Identifier() { return getToken(ContinuityParser.Identifier, 0); }
		public TerminalNode COLON() { return getToken(ContinuityParser.COLON, 0); }
		public TerminalNode ASSIGN() { return getToken(ContinuityParser.ASSIGN, 0); }
		public VariableTypeContext variableType() {
			return getRuleContext(VariableTypeContext.class,0);
		}
		public ArrayTypeContext arrayType() {
			return getRuleContext(ArrayTypeContext.class,0);
		}
		public ValueTargetContext valueTarget() {
			return getRuleContext(ValueTargetContext.class,0);
		}
		public ArrayLiteralContext arrayLiteral() {
			return getRuleContext(ArrayLiteralContext.class,0);
		}
		public VariableDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ContinuityParserListener ) ((ContinuityParserListener)listener).enterVariableDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ContinuityParserListener ) ((ContinuityParserListener)listener).exitVariableDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ContinuityParserVisitor ) return ((ContinuityParserVisitor<? extends T>)visitor).visitVariableDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableDeclarationContext variableDeclaration() throws RecognitionException {
		VariableDeclarationContext _localctx = new VariableDeclarationContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_variableDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86);
			match(LET);
			setState(87);
			match(Identifier);
			setState(88);
			match(COLON);
			setState(91);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				{
				setState(89);
				variableType();
				}
				break;
			case 2:
				{
				setState(90);
				arrayType();
				}
				break;
			}
			setState(93);
			match(ASSIGN);
			setState(96);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CTX:
			case EXT:
			case FN:
			case STD:
			case LET:
			case IntegerLiteral:
			case FloatingPointLiteral:
			case BooleanLiteral:
			case CharacterLiteral:
			case StringLiteral:
			case NullLiteral:
				{
				setState(94);
				valueTarget();
				}
				break;
			case LBRACE:
				{
				setState(95);
				arrayLiteral();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariableTypeContext extends ParserRuleContext {
		public TerminalNode CHAR() { return getToken(ContinuityParser.CHAR, 0); }
		public TerminalNode BOOL() { return getToken(ContinuityParser.BOOL, 0); }
		public TerminalNode INT8() { return getToken(ContinuityParser.INT8, 0); }
		public TerminalNode INT16() { return getToken(ContinuityParser.INT16, 0); }
		public TerminalNode INT32() { return getToken(ContinuityParser.INT32, 0); }
		public TerminalNode INT64() { return getToken(ContinuityParser.INT64, 0); }
		public TerminalNode FLOAT32() { return getToken(ContinuityParser.FLOAT32, 0); }
		public TerminalNode FLOAT64() { return getToken(ContinuityParser.FLOAT64, 0); }
		public TerminalNode STRING() { return getToken(ContinuityParser.STRING, 0); }
		public TerminalNode OBJECT() { return getToken(ContinuityParser.OBJECT, 0); }
		public VariableTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ContinuityParserListener ) ((ContinuityParserListener)listener).enterVariableType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ContinuityParserListener ) ((ContinuityParserListener)listener).exitVariableType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ContinuityParserVisitor ) return ((ContinuityParserVisitor<? extends T>)visitor).visitVariableType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableTypeContext variableType() throws RecognitionException {
		VariableTypeContext _localctx = new VariableTypeContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_variableType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(98);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CHAR) | (1L << BOOL) | (1L << INT8) | (1L << INT16) | (1L << INT32) | (1L << INT64) | (1L << FLOAT32) | (1L << FLOAT64) | (1L << STRING) | (1L << OBJECT))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArrayTypeContext extends ParserRuleContext {
		public VariableTypeContext variableType() {
			return getRuleContext(VariableTypeContext.class,0);
		}
		public TerminalNode LBRACK() { return getToken(ContinuityParser.LBRACK, 0); }
		public TerminalNode RBRACK() { return getToken(ContinuityParser.RBRACK, 0); }
		public ArrayTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ContinuityParserListener ) ((ContinuityParserListener)listener).enterArrayType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ContinuityParserListener ) ((ContinuityParserListener)listener).exitArrayType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ContinuityParserVisitor ) return ((ContinuityParserVisitor<? extends T>)visitor).visitArrayType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayTypeContext arrayType() throws RecognitionException {
		ArrayTypeContext _localctx = new ArrayTypeContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_arrayType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(100);
			variableType();
			setState(101);
			match(LBRACK);
			setState(102);
			match(RBRACK);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArrayLiteralContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(ContinuityParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(ContinuityParser.RBRACE, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ContinuityParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ContinuityParser.COMMA, i);
		}
		public ArrayLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ContinuityParserListener ) ((ContinuityParserListener)listener).enterArrayLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ContinuityParserListener ) ((ContinuityParserListener)listener).exitArrayLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ContinuityParserVisitor ) return ((ContinuityParserVisitor<? extends T>)visitor).visitArrayLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayLiteralContext arrayLiteral() throws RecognitionException {
		ArrayLiteralContext _localctx = new ArrayLiteralContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_arrayLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(104);
			match(LBRACE);
			setState(108); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(105);
				statement();
				setState(106);
				match(COMMA);
				}
				}
				setState(110); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CTX) | (1L << EXT) | (1L << FN) | (1L << STD) | (1L << IF) | (1L << LET))) != 0) );
			setState(112);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariableReferenceContext extends ParserRuleContext {
		public TerminalNode LET() { return getToken(ContinuityParser.LET, 0); }
		public TerminalNode DOT() { return getToken(ContinuityParser.DOT, 0); }
		public TerminalNode Identifier() { return getToken(ContinuityParser.Identifier, 0); }
		public ArrayIndexerContext arrayIndexer() {
			return getRuleContext(ArrayIndexerContext.class,0);
		}
		public VariableReferenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableReference; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ContinuityParserListener ) ((ContinuityParserListener)listener).enterVariableReference(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ContinuityParserListener ) ((ContinuityParserListener)listener).exitVariableReference(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ContinuityParserVisitor ) return ((ContinuityParserVisitor<? extends T>)visitor).visitVariableReference(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableReferenceContext variableReference() throws RecognitionException {
		VariableReferenceContext _localctx = new VariableReferenceContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_variableReference);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(114);
			match(LET);
			setState(115);
			match(DOT);
			setState(116);
			match(Identifier);
			setState(118);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				{
				setState(117);
				arrayIndexer();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArrayIndexerContext extends ParserRuleContext {
		public TerminalNode LBRACK() { return getToken(ContinuityParser.LBRACK, 0); }
		public TerminalNode IntegerLiteral() { return getToken(ContinuityParser.IntegerLiteral, 0); }
		public TerminalNode RBRACK() { return getToken(ContinuityParser.RBRACK, 0); }
		public ArrayIndexerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayIndexer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ContinuityParserListener ) ((ContinuityParserListener)listener).enterArrayIndexer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ContinuityParserListener ) ((ContinuityParserListener)listener).exitArrayIndexer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ContinuityParserVisitor ) return ((ContinuityParserVisitor<? extends T>)visitor).visitArrayIndexer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayIndexerContext arrayIndexer() throws RecognitionException {
		ArrayIndexerContext _localctx = new ArrayIndexerContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_arrayIndexer);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(120);
			match(LBRACK);
			setState(121);
			match(IntegerLiteral);
			setState(122);
			match(RBRACK);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExternalLayoutContext extends ParserRuleContext {
		public ExternalLayoutContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_externalLayout; }
	 
		public ExternalLayoutContext() { }
		public void copyFrom(ExternalLayoutContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class MultiExternalLayoutDeclarationContext extends ExternalLayoutContext {
		public TerminalNode EXT() { return getToken(ContinuityParser.EXT, 0); }
		public TerminalNode LBRACE() { return getToken(ContinuityParser.LBRACE, 0); }
		public ExternalEntriesContext externalEntries() {
			return getRuleContext(ExternalEntriesContext.class,0);
		}
		public TerminalNode RBRACE() { return getToken(ContinuityParser.RBRACE, 0); }
		public MultiExternalLayoutDeclarationContext(ExternalLayoutContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ContinuityParserListener ) ((ContinuityParserListener)listener).enterMultiExternalLayoutDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ContinuityParserListener ) ((ContinuityParserListener)listener).exitMultiExternalLayoutDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ContinuityParserVisitor ) return ((ContinuityParserVisitor<? extends T>)visitor).visitMultiExternalLayoutDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SingleExternalLayoutDeclarationContext extends ExternalLayoutContext {
		public TerminalNode EXT() { return getToken(ContinuityParser.EXT, 0); }
		public ReferenceContext reference() {
			return getRuleContext(ReferenceContext.class,0);
		}
		public SingleExternalLayoutDeclarationContext(ExternalLayoutContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ContinuityParserListener ) ((ContinuityParserListener)listener).enterSingleExternalLayoutDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ContinuityParserListener ) ((ContinuityParserListener)listener).exitSingleExternalLayoutDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ContinuityParserVisitor ) return ((ContinuityParserVisitor<? extends T>)visitor).visitSingleExternalLayoutDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExternalLayoutContext externalLayout() throws RecognitionException {
		ExternalLayoutContext _localctx = new ExternalLayoutContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_externalLayout);
		try {
			setState(131);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				_localctx = new SingleExternalLayoutDeclarationContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(124);
				match(EXT);
				setState(125);
				reference();
				}
				break;
			case 2:
				_localctx = new MultiExternalLayoutDeclarationContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(126);
				match(EXT);
				setState(127);
				match(LBRACE);
				setState(128);
				externalEntries();
				setState(129);
				match(RBRACE);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExternalEntriesContext extends ParserRuleContext {
		public List<ReferenceContext> reference() {
			return getRuleContexts(ReferenceContext.class);
		}
		public ReferenceContext reference(int i) {
			return getRuleContext(ReferenceContext.class,i);
		}
		public List<TerminalNode> SEMI() { return getTokens(ContinuityParser.SEMI); }
		public TerminalNode SEMI(int i) {
			return getToken(ContinuityParser.SEMI, i);
		}
		public ExternalEntriesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_externalEntries; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ContinuityParserListener ) ((ContinuityParserListener)listener).enterExternalEntries(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ContinuityParserListener ) ((ContinuityParserListener)listener).exitExternalEntries(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ContinuityParserVisitor ) return ((ContinuityParserVisitor<? extends T>)visitor).visitExternalEntries(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExternalEntriesContext externalEntries() throws RecognitionException {
		ExternalEntriesContext _localctx = new ExternalEntriesContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_externalEntries);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(136); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(133);
				reference();
				setState(134);
				match(SEMI);
				}
				}
				setState(138); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==Identifier );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExternalEntryReferenceContext extends ParserRuleContext {
		public TerminalNode EXT() { return getToken(ContinuityParser.EXT, 0); }
		public TerminalNode COLONCOLON() { return getToken(ContinuityParser.COLONCOLON, 0); }
		public TerminalNode Identifier() { return getToken(ContinuityParser.Identifier, 0); }
		public ExternalEntryReferenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_externalEntryReference; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ContinuityParserListener ) ((ContinuityParserListener)listener).enterExternalEntryReference(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ContinuityParserListener ) ((ContinuityParserListener)listener).exitExternalEntryReference(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ContinuityParserVisitor ) return ((ContinuityParserVisitor<? extends T>)visitor).visitExternalEntryReference(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExternalEntryReferenceContext externalEntryReference() throws RecognitionException {
		ExternalEntryReferenceContext _localctx = new ExternalEntryReferenceContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_externalEntryReference);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(140);
			match(EXT);
			setState(141);
			match(COLONCOLON);
			setState(142);
			match(Identifier);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExternalEntryEnumConstantReferenceContext extends ParserRuleContext {
		public ExternalEntryReferenceContext externalEntryReference() {
			return getRuleContext(ExternalEntryReferenceContext.class,0);
		}
		public TerminalNode DOT() { return getToken(ContinuityParser.DOT, 0); }
		public TerminalNode Identifier() { return getToken(ContinuityParser.Identifier, 0); }
		public ExternalEntryEnumConstantReferenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_externalEntryEnumConstantReference; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ContinuityParserListener ) ((ContinuityParserListener)listener).enterExternalEntryEnumConstantReference(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ContinuityParserListener ) ((ContinuityParserListener)listener).exitExternalEntryEnumConstantReference(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ContinuityParserVisitor ) return ((ContinuityParserVisitor<? extends T>)visitor).visitExternalEntryEnumConstantReference(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExternalEntryEnumConstantReferenceContext externalEntryEnumConstantReference() throws RecognitionException {
		ExternalEntryEnumConstantReferenceContext _localctx = new ExternalEntryEnumConstantReferenceContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_externalEntryEnumConstantReference);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(144);
			externalEntryReference();
			setState(145);
			match(DOT);
			setState(146);
			match(Identifier);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ContextLayoutContext extends ParserRuleContext {
		public ContextLayoutContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_contextLayout; }
	 
		public ContextLayoutContext() { }
		public void copyFrom(ContextLayoutContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class MultiContextLayoutDeclarationContext extends ContextLayoutContext {
		public TerminalNode CTX() { return getToken(ContinuityParser.CTX, 0); }
		public TerminalNode LBRACE() { return getToken(ContinuityParser.LBRACE, 0); }
		public ContextEntriesContext contextEntries() {
			return getRuleContext(ContextEntriesContext.class,0);
		}
		public TerminalNode RBRACE() { return getToken(ContinuityParser.RBRACE, 0); }
		public MultiContextLayoutDeclarationContext(ContextLayoutContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ContinuityParserListener ) ((ContinuityParserListener)listener).enterMultiContextLayoutDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ContinuityParserListener ) ((ContinuityParserListener)listener).exitMultiContextLayoutDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ContinuityParserVisitor ) return ((ContinuityParserVisitor<? extends T>)visitor).visitMultiContextLayoutDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SingleContextLayoutDeclarationContext extends ContextLayoutContext {
		public TerminalNode CTX() { return getToken(ContinuityParser.CTX, 0); }
		public TerminalNode Identifier() { return getToken(ContinuityParser.Identifier, 0); }
		public SingleContextLayoutDeclarationContext(ContextLayoutContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ContinuityParserListener ) ((ContinuityParserListener)listener).enterSingleContextLayoutDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ContinuityParserListener ) ((ContinuityParserListener)listener).exitSingleContextLayoutDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ContinuityParserVisitor ) return ((ContinuityParserVisitor<? extends T>)visitor).visitSingleContextLayoutDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ContextLayoutContext contextLayout() throws RecognitionException {
		ContextLayoutContext _localctx = new ContextLayoutContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_contextLayout);
		try {
			setState(155);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				_localctx = new SingleContextLayoutDeclarationContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(148);
				match(CTX);
				setState(149);
				match(Identifier);
				}
				break;
			case 2:
				_localctx = new MultiContextLayoutDeclarationContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(150);
				match(CTX);
				setState(151);
				match(LBRACE);
				setState(152);
				contextEntries();
				setState(153);
				match(RBRACE);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ContextEntriesContext extends ParserRuleContext {
		public List<TerminalNode> Identifier() { return getTokens(ContinuityParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(ContinuityParser.Identifier, i);
		}
		public List<TerminalNode> SEMI() { return getTokens(ContinuityParser.SEMI); }
		public TerminalNode SEMI(int i) {
			return getToken(ContinuityParser.SEMI, i);
		}
		public ContextEntriesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_contextEntries; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ContinuityParserListener ) ((ContinuityParserListener)listener).enterContextEntries(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ContinuityParserListener ) ((ContinuityParserListener)listener).exitContextEntries(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ContinuityParserVisitor ) return ((ContinuityParserVisitor<? extends T>)visitor).visitContextEntries(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ContextEntriesContext contextEntries() throws RecognitionException {
		ContextEntriesContext _localctx = new ContextEntriesContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_contextEntries);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(159); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(157);
				match(Identifier);
				setState(158);
				match(SEMI);
				}
				}
				setState(161); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==Identifier );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ContextEntryReferenceContext extends ParserRuleContext {
		public TerminalNode CTX() { return getToken(ContinuityParser.CTX, 0); }
		public TerminalNode COLONCOLON() { return getToken(ContinuityParser.COLONCOLON, 0); }
		public TerminalNode Identifier() { return getToken(ContinuityParser.Identifier, 0); }
		public ContextEntryReferenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_contextEntryReference; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ContinuityParserListener ) ((ContinuityParserListener)listener).enterContextEntryReference(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ContinuityParserListener ) ((ContinuityParserListener)listener).exitContextEntryReference(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ContinuityParserVisitor ) return ((ContinuityParserVisitor<? extends T>)visitor).visitContextEntryReference(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ContextEntryReferenceContext contextEntryReference() throws RecognitionException {
		ContextEntryReferenceContext _localctx = new ContextEntryReferenceContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_contextEntryReference);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(163);
			match(CTX);
			setState(164);
			match(COLONCOLON);
			setState(165);
			match(Identifier);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionContext extends ParserRuleContext {
		public TerminalNode FN() { return getToken(ContinuityParser.FN, 0); }
		public TerminalNode Identifier() { return getToken(ContinuityParser.Identifier, 0); }
		public TerminalNode LPAREN() { return getToken(ContinuityParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(ContinuityParser.RPAREN, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public FunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ContinuityParserListener ) ((ContinuityParserListener)listener).enterFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ContinuityParserListener ) ((ContinuityParserListener)listener).exitFunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ContinuityParserVisitor ) return ((ContinuityParserVisitor<? extends T>)visitor).visitFunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionContext function() throws RecognitionException {
		FunctionContext _localctx = new FunctionContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_function);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(167);
			match(FN);
			setState(168);
			match(Identifier);
			setState(169);
			match(LPAREN);
			setState(170);
			match(RPAREN);
			setState(171);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(ContinuityParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(ContinuityParser.RBRACE, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<TerminalNode> SEMI() { return getTokens(ContinuityParser.SEMI); }
		public TerminalNode SEMI(int i) {
			return getToken(ContinuityParser.SEMI, i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ContinuityParserListener ) ((ContinuityParserListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ContinuityParserListener ) ((ContinuityParserListener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ContinuityParserVisitor ) return ((ContinuityParserVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(173);
			match(LBRACE);
			setState(177); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(174);
				statement();
				setState(175);
				match(SEMI);
				}
				}
				setState(179); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CTX) | (1L << EXT) | (1L << FN) | (1L << STD) | (1L << IF) | (1L << LET))) != 0) );
			setState(181);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InvocationContext extends ParserRuleContext {
		public InvocationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_invocation; }
	 
		public InvocationContext() { }
		public void copyFrom(InvocationContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ContextReferenceInvocationContext extends InvocationContext {
		public ContextEntryReferenceContext contextEntryReference() {
			return getRuleContext(ContextEntryReferenceContext.class,0);
		}
		public TerminalNode ARROW() { return getToken(ContinuityParser.ARROW, 0); }
		public MethodInvocationChainContext methodInvocationChain() {
			return getRuleContext(MethodInvocationChainContext.class,0);
		}
		public ContextReferenceInvocationContext(InvocationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ContinuityParserListener ) ((ContinuityParserListener)listener).enterContextReferenceInvocation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ContinuityParserListener ) ((ContinuityParserListener)listener).exitContextReferenceInvocation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ContinuityParserVisitor ) return ((ContinuityParserVisitor<? extends T>)visitor).visitContextReferenceInvocation(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExternalReferenceInvocationContext extends InvocationContext {
		public ExternalEntryReferenceContext externalEntryReference() {
			return getRuleContext(ExternalEntryReferenceContext.class,0);
		}
		public TerminalNode ARROW() { return getToken(ContinuityParser.ARROW, 0); }
		public MethodInvocationChainContext methodInvocationChain() {
			return getRuleContext(MethodInvocationChainContext.class,0);
		}
		public ExternalReferenceInvocationContext(InvocationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ContinuityParserListener ) ((ContinuityParserListener)listener).enterExternalReferenceInvocation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ContinuityParserListener ) ((ContinuityParserListener)listener).exitExternalReferenceInvocation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ContinuityParserVisitor ) return ((ContinuityParserVisitor<? extends T>)visitor).visitExternalReferenceInvocation(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EnumConstantMethodInvocationParamContext extends InvocationContext {
		public ExternalEntryEnumConstantReferenceContext externalEntryEnumConstantReference() {
			return getRuleContext(ExternalEntryEnumConstantReferenceContext.class,0);
		}
		public TerminalNode ARROW() { return getToken(ContinuityParser.ARROW, 0); }
		public ReferenceTargetContext referenceTarget() {
			return getRuleContext(ReferenceTargetContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(ContinuityParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(ContinuityParser.RPAREN, 0); }
		public EnumConstantMethodInvocationParamContext(InvocationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ContinuityParserListener ) ((ContinuityParserListener)listener).enterEnumConstantMethodInvocationParam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ContinuityParserListener ) ((ContinuityParserListener)listener).exitEnumConstantMethodInvocationParam(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ContinuityParserVisitor ) return ((ContinuityParserVisitor<? extends T>)visitor).visitEnumConstantMethodInvocationParam(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StdInvocationContext extends InvocationContext {
		public TerminalNode STD() { return getToken(ContinuityParser.STD, 0); }
		public TerminalNode COLONCOLON() { return getToken(ContinuityParser.COLONCOLON, 0); }
		public ReferenceTargetContext referenceTarget() {
			return getRuleContext(ReferenceTargetContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(ContinuityParser.LPAREN, 0); }
		public ParamsContext params() {
			return getRuleContext(ParamsContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(ContinuityParser.RPAREN, 0); }
		public StdInvocationContext(InvocationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ContinuityParserListener ) ((ContinuityParserListener)listener).enterStdInvocation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ContinuityParserListener ) ((ContinuityParserListener)listener).exitStdInvocation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ContinuityParserVisitor ) return ((ContinuityParserVisitor<? extends T>)visitor).visitStdInvocation(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FunctionInvocationContext extends InvocationContext {
		public TerminalNode FN() { return getToken(ContinuityParser.FN, 0); }
		public TerminalNode DOT() { return getToken(ContinuityParser.DOT, 0); }
		public ReferenceTargetContext referenceTarget() {
			return getRuleContext(ReferenceTargetContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(ContinuityParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(ContinuityParser.RPAREN, 0); }
		public FunctionInvocationContext(InvocationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ContinuityParserListener ) ((ContinuityParserListener)listener).enterFunctionInvocation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ContinuityParserListener ) ((ContinuityParserListener)listener).exitFunctionInvocation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ContinuityParserVisitor ) return ((ContinuityParserVisitor<? extends T>)visitor).visitFunctionInvocation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InvocationContext invocation() throws RecognitionException {
		InvocationContext _localctx = new InvocationContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_invocation);
		try {
			setState(210);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				_localctx = new StdInvocationContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(183);
				match(STD);
				setState(184);
				match(COLONCOLON);
				setState(185);
				referenceTarget();
				setState(186);
				match(LPAREN);
				setState(187);
				params();
				setState(188);
				match(RPAREN);
				}
				break;
			case 2:
				_localctx = new FunctionInvocationContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(190);
				match(FN);
				setState(191);
				match(DOT);
				setState(192);
				referenceTarget();
				setState(193);
				match(LPAREN);
				setState(194);
				match(RPAREN);
				}
				break;
			case 3:
				_localctx = new ExternalReferenceInvocationContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(196);
				externalEntryReference();
				setState(197);
				match(ARROW);
				setState(198);
				methodInvocationChain();
				}
				break;
			case 4:
				_localctx = new ContextReferenceInvocationContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(200);
				contextEntryReference();
				setState(201);
				match(ARROW);
				setState(202);
				methodInvocationChain();
				}
				break;
			case 5:
				_localctx = new EnumConstantMethodInvocationParamContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(204);
				externalEntryEnumConstantReference();
				setState(205);
				match(ARROW);
				setState(206);
				referenceTarget();
				setState(207);
				match(LPAREN);
				setState(208);
				match(RPAREN);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MethodInvocationChainContext extends ParserRuleContext {
		public List<MethodInvocationContext> methodInvocation() {
			return getRuleContexts(MethodInvocationContext.class);
		}
		public MethodInvocationContext methodInvocation(int i) {
			return getRuleContext(MethodInvocationContext.class,i);
		}
		public List<TerminalNode> DOT() { return getTokens(ContinuityParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(ContinuityParser.DOT, i);
		}
		public MethodInvocationChainContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodInvocationChain; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ContinuityParserListener ) ((ContinuityParserListener)listener).enterMethodInvocationChain(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ContinuityParserListener ) ((ContinuityParserListener)listener).exitMethodInvocationChain(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ContinuityParserVisitor ) return ((ContinuityParserVisitor<? extends T>)visitor).visitMethodInvocationChain(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodInvocationChainContext methodInvocationChain() throws RecognitionException {
		MethodInvocationChainContext _localctx = new MethodInvocationChainContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_methodInvocationChain);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(212);
			methodInvocation();
			setState(217);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(213);
					match(DOT);
					setState(214);
					methodInvocation();
					}
					} 
				}
				setState(219);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MethodInvocationContext extends ParserRuleContext {
		public ReferenceTargetContext referenceTarget() {
			return getRuleContext(ReferenceTargetContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(ContinuityParser.LPAREN, 0); }
		public ParamsContext params() {
			return getRuleContext(ParamsContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(ContinuityParser.RPAREN, 0); }
		public MethodInvocationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodInvocation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ContinuityParserListener ) ((ContinuityParserListener)listener).enterMethodInvocation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ContinuityParserListener ) ((ContinuityParserListener)listener).exitMethodInvocation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ContinuityParserVisitor ) return ((ContinuityParserVisitor<? extends T>)visitor).visitMethodInvocation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodInvocationContext methodInvocation() throws RecognitionException {
		MethodInvocationContext _localctx = new MethodInvocationContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_methodInvocation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(220);
			referenceTarget();
			setState(221);
			match(LPAREN);
			setState(222);
			params();
			setState(223);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParamsContext extends ParserRuleContext {
		public List<ParamContext> param() {
			return getRuleContexts(ParamContext.class);
		}
		public ParamContext param(int i) {
			return getRuleContext(ParamContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ContinuityParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ContinuityParser.COMMA, i);
		}
		public ParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_params; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ContinuityParserListener ) ((ContinuityParserListener)listener).enterParams(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ContinuityParserListener ) ((ContinuityParserListener)listener).exitParams(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ContinuityParserVisitor ) return ((ContinuityParserVisitor<? extends T>)visitor).visitParams(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamsContext params() throws RecognitionException {
		ParamsContext _localctx = new ParamsContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_params);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(233);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CTX) | (1L << EXT) | (1L << FN) | (1L << STD) | (1L << LET) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << NullLiteral) | (1L << LPAREN) | (1L << BANG))) != 0)) {
				{
				setState(225);
				param();
				setState(230);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(226);
					match(COMMA);
					setState(227);
					param();
					}
					}
					setState(232);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParamContext extends ParserRuleContext {
		public ParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param; }
	 
		public ParamContext() { }
		public void copyFrom(ParamContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ContextEntryReferenceParamContext extends ParamContext {
		public ContextEntryReferenceContext contextEntryReference() {
			return getRuleContext(ContextEntryReferenceContext.class,0);
		}
		public ContextEntryReferenceParamContext(ParamContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ContinuityParserListener ) ((ContinuityParserListener)listener).enterContextEntryReferenceParam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ContinuityParserListener ) ((ContinuityParserListener)listener).exitContextEntryReferenceParam(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ContinuityParserVisitor ) return ((ContinuityParserVisitor<? extends T>)visitor).visitContextEntryReferenceParam(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EnumConstantReferenceParamContext extends ParamContext {
		public ExternalEntryEnumConstantReferenceContext externalEntryEnumConstantReference() {
			return getRuleContext(ExternalEntryEnumConstantReferenceContext.class,0);
		}
		public EnumConstantReferenceParamContext(ParamContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ContinuityParserListener ) ((ContinuityParserListener)listener).enterEnumConstantReferenceParam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ContinuityParserListener ) ((ContinuityParserListener)listener).exitEnumConstantReferenceParam(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ContinuityParserVisitor ) return ((ContinuityParserVisitor<? extends T>)visitor).visitEnumConstantReferenceParam(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LiteralParamContext extends ParamContext {
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public LiteralParamContext(ParamContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ContinuityParserListener ) ((ContinuityParserListener)listener).enterLiteralParam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ContinuityParserListener ) ((ContinuityParserListener)listener).exitLiteralParam(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ContinuityParserVisitor ) return ((ContinuityParserVisitor<? extends T>)visitor).visitLiteralParam(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class InvocationParamContext extends ParamContext {
		public InvocationContext invocation() {
			return getRuleContext(InvocationContext.class,0);
		}
		public InvocationParamContext(ParamContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ContinuityParserListener ) ((ContinuityParserListener)listener).enterInvocationParam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ContinuityParserListener ) ((ContinuityParserListener)listener).exitInvocationParam(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ContinuityParserVisitor ) return ((ContinuityParserVisitor<? extends T>)visitor).visitInvocationParam(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BooleanExpressionParamContext extends ParamContext {
		public BooleanExpresionContext booleanExpresion() {
			return getRuleContext(BooleanExpresionContext.class,0);
		}
		public BooleanExpressionParamContext(ParamContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ContinuityParserListener ) ((ContinuityParserListener)listener).enterBooleanExpressionParam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ContinuityParserListener ) ((ContinuityParserListener)listener).exitBooleanExpressionParam(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ContinuityParserVisitor ) return ((ContinuityParserVisitor<? extends T>)visitor).visitBooleanExpressionParam(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class VariableReferenceParamContext extends ParamContext {
		public VariableReferenceContext variableReference() {
			return getRuleContext(VariableReferenceContext.class,0);
		}
		public VariableReferenceParamContext(ParamContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ContinuityParserListener ) ((ContinuityParserListener)listener).enterVariableReferenceParam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ContinuityParserListener ) ((ContinuityParserListener)listener).exitVariableReferenceParam(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ContinuityParserVisitor ) return ((ContinuityParserVisitor<? extends T>)visitor).visitVariableReferenceParam(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamContext param() throws RecognitionException {
		ParamContext _localctx = new ParamContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_param);
		try {
			setState(241);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				_localctx = new LiteralParamContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(235);
				literal();
				}
				break;
			case 2:
				_localctx = new ContextEntryReferenceParamContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(236);
				contextEntryReference();
				}
				break;
			case 3:
				_localctx = new InvocationParamContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(237);
				invocation();
				}
				break;
			case 4:
				_localctx = new EnumConstantReferenceParamContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(238);
				externalEntryEnumConstantReference();
				}
				break;
			case 5:
				_localctx = new BooleanExpressionParamContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(239);
				booleanExpresion(0);
				}
				break;
			case 6:
				_localctx = new VariableReferenceParamContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(240);
				variableReference();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReferenceContext extends ParserRuleContext {
		public ReferenceTargetContext referenceTarget() {
			return getRuleContext(ReferenceTargetContext.class,0);
		}
		public ReferenceChainContext referenceChain() {
			return getRuleContext(ReferenceChainContext.class,0);
		}
		public ReferenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_reference; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ContinuityParserListener ) ((ContinuityParserListener)listener).enterReference(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ContinuityParserListener ) ((ContinuityParserListener)listener).exitReference(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ContinuityParserVisitor ) return ((ContinuityParserVisitor<? extends T>)visitor).visitReference(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReferenceContext reference() throws RecognitionException {
		ReferenceContext _localctx = new ReferenceContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_reference);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(244);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				{
				setState(243);
				referenceChain();
				}
				break;
			}
			setState(246);
			referenceTarget();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReferenceTargetContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(ContinuityParser.Identifier, 0); }
		public ReferenceTargetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_referenceTarget; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ContinuityParserListener ) ((ContinuityParserListener)listener).enterReferenceTarget(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ContinuityParserListener ) ((ContinuityParserListener)listener).exitReferenceTarget(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ContinuityParserVisitor ) return ((ContinuityParserVisitor<? extends T>)visitor).visitReferenceTarget(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReferenceTargetContext referenceTarget() throws RecognitionException {
		ReferenceTargetContext _localctx = new ReferenceTargetContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_referenceTarget);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(248);
			match(Identifier);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReferenceChainContext extends ParserRuleContext {
		public List<TerminalNode> Identifier() { return getTokens(ContinuityParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(ContinuityParser.Identifier, i);
		}
		public List<TerminalNode> DOT() { return getTokens(ContinuityParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(ContinuityParser.DOT, i);
		}
		public List<TerminalNode> DOLLAR() { return getTokens(ContinuityParser.DOLLAR); }
		public TerminalNode DOLLAR(int i) {
			return getToken(ContinuityParser.DOLLAR, i);
		}
		public ReferenceChainContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_referenceChain; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ContinuityParserListener ) ((ContinuityParserListener)listener).enterReferenceChain(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ContinuityParserListener ) ((ContinuityParserListener)listener).exitReferenceChain(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ContinuityParserVisitor ) return ((ContinuityParserVisitor<? extends T>)visitor).visitReferenceChain(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReferenceChainContext referenceChain() throws RecognitionException {
		ReferenceChainContext _localctx = new ReferenceChainContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_referenceChain);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(252); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(250);
					match(Identifier);
					setState(251);
					_la = _input.LA(1);
					if ( !(_la==DOT || _la==DOLLAR) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(254); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BooleanExpresionContext extends ParserRuleContext {
		public BooleanExpresionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_booleanExpresion; }
	 
		public BooleanExpresionContext() { }
		public void copyFrom(BooleanExpresionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ComparatorBooleanExpressionContext extends BooleanExpresionContext {
		public BooleanExpresionContext left;
		public BooleanExpresionContext right;
		public ComparatorContext comparator() {
			return getRuleContext(ComparatorContext.class,0);
		}
		public List<BooleanExpresionContext> booleanExpresion() {
			return getRuleContexts(BooleanExpresionContext.class);
		}
		public BooleanExpresionContext booleanExpresion(int i) {
			return getRuleContext(BooleanExpresionContext.class,i);
		}
		public ComparatorBooleanExpressionContext(BooleanExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ContinuityParserListener ) ((ContinuityParserListener)listener).enterComparatorBooleanExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ContinuityParserListener ) ((ContinuityParserListener)listener).exitComparatorBooleanExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ContinuityParserVisitor ) return ((ContinuityParserVisitor<? extends T>)visitor).visitComparatorBooleanExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParenBooleanExpressionContext extends BooleanExpresionContext {
		public TerminalNode LPAREN() { return getToken(ContinuityParser.LPAREN, 0); }
		public BooleanExpresionContext booleanExpresion() {
			return getRuleContext(BooleanExpresionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(ContinuityParser.RPAREN, 0); }
		public ParenBooleanExpressionContext(BooleanExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ContinuityParserListener ) ((ContinuityParserListener)listener).enterParenBooleanExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ContinuityParserListener ) ((ContinuityParserListener)listener).exitParenBooleanExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ContinuityParserVisitor ) return ((ContinuityParserVisitor<? extends T>)visitor).visitParenBooleanExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BinaryBooleanExpressionContext extends BooleanExpresionContext {
		public BooleanExpresionContext left;
		public BooleanExpresionContext right;
		public ComparisonJoinContext comparisonJoin() {
			return getRuleContext(ComparisonJoinContext.class,0);
		}
		public List<BooleanExpresionContext> booleanExpresion() {
			return getRuleContexts(BooleanExpresionContext.class);
		}
		public BooleanExpresionContext booleanExpresion(int i) {
			return getRuleContext(BooleanExpresionContext.class,i);
		}
		public BinaryBooleanExpressionContext(BooleanExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ContinuityParserListener ) ((ContinuityParserListener)listener).enterBinaryBooleanExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ContinuityParserListener ) ((ContinuityParserListener)listener).exitBinaryBooleanExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ContinuityParserVisitor ) return ((ContinuityParserVisitor<? extends T>)visitor).visitBinaryBooleanExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NegationBooleanExpressionContext extends BooleanExpresionContext {
		public TerminalNode BANG() { return getToken(ContinuityParser.BANG, 0); }
		public BooleanExpresionContext booleanExpresion() {
			return getRuleContext(BooleanExpresionContext.class,0);
		}
		public NegationBooleanExpressionContext(BooleanExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ContinuityParserListener ) ((ContinuityParserListener)listener).enterNegationBooleanExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ContinuityParserListener ) ((ContinuityParserListener)listener).exitNegationBooleanExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ContinuityParserVisitor ) return ((ContinuityParserVisitor<? extends T>)visitor).visitNegationBooleanExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TargetBooleanExpressionContext extends BooleanExpresionContext {
		public ValueTargetContext valueTarget() {
			return getRuleContext(ValueTargetContext.class,0);
		}
		public TargetBooleanExpressionContext(BooleanExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ContinuityParserListener ) ((ContinuityParserListener)listener).enterTargetBooleanExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ContinuityParserListener ) ((ContinuityParserListener)listener).exitTargetBooleanExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ContinuityParserVisitor ) return ((ContinuityParserVisitor<? extends T>)visitor).visitTargetBooleanExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BooleanExpresionContext booleanExpresion() throws RecognitionException {
		return booleanExpresion(0);
	}

	private BooleanExpresionContext booleanExpresion(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		BooleanExpresionContext _localctx = new BooleanExpresionContext(_ctx, _parentState);
		BooleanExpresionContext _prevctx = _localctx;
		int _startState = 50;
		enterRecursionRule(_localctx, 50, RULE_booleanExpresion, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(264);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LPAREN:
				{
				_localctx = new ParenBooleanExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(257);
				match(LPAREN);
				setState(258);
				booleanExpresion(0);
				setState(259);
				match(RPAREN);
				}
				break;
			case BANG:
				{
				_localctx = new NegationBooleanExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(261);
				match(BANG);
				setState(262);
				booleanExpresion(4);
				}
				break;
			case CTX:
			case EXT:
			case FN:
			case STD:
			case LET:
			case IntegerLiteral:
			case FloatingPointLiteral:
			case BooleanLiteral:
			case CharacterLiteral:
			case StringLiteral:
			case NullLiteral:
				{
				_localctx = new TargetBooleanExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(263);
				valueTarget();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(276);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(274);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
					case 1:
						{
						_localctx = new ComparatorBooleanExpressionContext(new BooleanExpresionContext(_parentctx, _parentState));
						((ComparatorBooleanExpressionContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_booleanExpresion);
						setState(266);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(267);
						comparator();
						setState(268);
						((ComparatorBooleanExpressionContext)_localctx).right = booleanExpresion(4);
						}
						break;
					case 2:
						{
						_localctx = new BinaryBooleanExpressionContext(new BooleanExpresionContext(_parentctx, _parentState));
						((BinaryBooleanExpressionContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_booleanExpresion);
						setState(270);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(271);
						comparisonJoin();
						setState(272);
						((BinaryBooleanExpressionContext)_localctx).right = booleanExpresion(3);
						}
						break;
					}
					} 
				}
				setState(278);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ComparisonJoinContext extends ParserRuleContext {
		public TerminalNode AND() { return getToken(ContinuityParser.AND, 0); }
		public TerminalNode OR() { return getToken(ContinuityParser.OR, 0); }
		public TerminalNode CARET() { return getToken(ContinuityParser.CARET, 0); }
		public ComparisonJoinContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparisonJoin; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ContinuityParserListener ) ((ContinuityParserListener)listener).enterComparisonJoin(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ContinuityParserListener ) ((ContinuityParserListener)listener).exitComparisonJoin(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ContinuityParserVisitor ) return ((ContinuityParserVisitor<? extends T>)visitor).visitComparisonJoin(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComparisonJoinContext comparisonJoin() throws RecognitionException {
		ComparisonJoinContext _localctx = new ComparisonJoinContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_comparisonJoin);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(279);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AND) | (1L << OR) | (1L << CARET))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ComparatorContext extends ParserRuleContext {
		public TerminalNode GT() { return getToken(ContinuityParser.GT, 0); }
		public TerminalNode LT() { return getToken(ContinuityParser.LT, 0); }
		public TerminalNode LE() { return getToken(ContinuityParser.LE, 0); }
		public TerminalNode GE() { return getToken(ContinuityParser.GE, 0); }
		public TerminalNode EQUAL() { return getToken(ContinuityParser.EQUAL, 0); }
		public TerminalNode NOTEQUAL() { return getToken(ContinuityParser.NOTEQUAL, 0); }
		public ComparatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ContinuityParserListener ) ((ContinuityParserListener)listener).enterComparator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ContinuityParserListener ) ((ContinuityParserListener)listener).exitComparator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ContinuityParserVisitor ) return ((ContinuityParserVisitor<? extends T>)visitor).visitComparator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComparatorContext comparator() throws RecognitionException {
		ComparatorContext _localctx = new ComparatorContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_comparator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(281);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GT) | (1L << LT) | (1L << EQUAL) | (1L << LE) | (1L << GE) | (1L << NOTEQUAL))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ValueTargetContext extends ParserRuleContext {
		public ExternalEntryReferenceContext externalEntryReference() {
			return getRuleContext(ExternalEntryReferenceContext.class,0);
		}
		public ContextEntryReferenceContext contextEntryReference() {
			return getRuleContext(ContextEntryReferenceContext.class,0);
		}
		public InvocationContext invocation() {
			return getRuleContext(InvocationContext.class,0);
		}
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public VariableReferenceContext variableReference() {
			return getRuleContext(VariableReferenceContext.class,0);
		}
		public ValueTargetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_valueTarget; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ContinuityParserListener ) ((ContinuityParserListener)listener).enterValueTarget(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ContinuityParserListener ) ((ContinuityParserListener)listener).exitValueTarget(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ContinuityParserVisitor ) return ((ContinuityParserVisitor<? extends T>)visitor).visitValueTarget(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueTargetContext valueTarget() throws RecognitionException {
		ValueTargetContext _localctx = new ValueTargetContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_valueTarget);
		try {
			setState(288);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(283);
				externalEntryReference();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(284);
				contextEntryReference();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(285);
				invocation();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(286);
				literal();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(287);
				variableReference();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IfConditionContext extends ParserRuleContext {
		public IfBranchContext ifBranch() {
			return getRuleContext(IfBranchContext.class,0);
		}
		public List<ElseIfBranchContext> elseIfBranch() {
			return getRuleContexts(ElseIfBranchContext.class);
		}
		public ElseIfBranchContext elseIfBranch(int i) {
			return getRuleContext(ElseIfBranchContext.class,i);
		}
		public ElseBranchContext elseBranch() {
			return getRuleContext(ElseBranchContext.class,0);
		}
		public IfConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifCondition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ContinuityParserListener ) ((ContinuityParserListener)listener).enterIfCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ContinuityParserListener ) ((ContinuityParserListener)listener).exitIfCondition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ContinuityParserVisitor ) return ((ContinuityParserVisitor<? extends T>)visitor).visitIfCondition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfConditionContext ifCondition() throws RecognitionException {
		IfConditionContext _localctx = new IfConditionContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_ifCondition);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(290);
			ifBranch();
			setState(294);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(291);
					elseIfBranch();
					}
					} 
				}
				setState(296);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			}
			setState(298);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(297);
				elseBranch();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IfBranchContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(ContinuityParser.IF, 0); }
		public BooleanExpresionContext booleanExpresion() {
			return getRuleContext(BooleanExpresionContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public IfBranchContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifBranch; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ContinuityParserListener ) ((ContinuityParserListener)listener).enterIfBranch(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ContinuityParserListener ) ((ContinuityParserListener)listener).exitIfBranch(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ContinuityParserVisitor ) return ((ContinuityParserVisitor<? extends T>)visitor).visitIfBranch(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfBranchContext ifBranch() throws RecognitionException {
		IfBranchContext _localctx = new IfBranchContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_ifBranch);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(300);
			match(IF);
			setState(301);
			booleanExpresion(0);
			setState(302);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ElseIfBranchContext extends ParserRuleContext {
		public TerminalNode ELSE() { return getToken(ContinuityParser.ELSE, 0); }
		public IfBranchContext ifBranch() {
			return getRuleContext(IfBranchContext.class,0);
		}
		public ElseIfBranchContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elseIfBranch; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ContinuityParserListener ) ((ContinuityParserListener)listener).enterElseIfBranch(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ContinuityParserListener ) ((ContinuityParserListener)listener).exitElseIfBranch(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ContinuityParserVisitor ) return ((ContinuityParserVisitor<? extends T>)visitor).visitElseIfBranch(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElseIfBranchContext elseIfBranch() throws RecognitionException {
		ElseIfBranchContext _localctx = new ElseIfBranchContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_elseIfBranch);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(304);
			match(ELSE);
			setState(305);
			ifBranch();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ElseBranchContext extends ParserRuleContext {
		public TerminalNode ELSE() { return getToken(ContinuityParser.ELSE, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ElseBranchContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elseBranch; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ContinuityParserListener ) ((ContinuityParserListener)listener).enterElseBranch(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ContinuityParserListener ) ((ContinuityParserListener)listener).exitElseBranch(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ContinuityParserVisitor ) return ((ContinuityParserVisitor<? extends T>)visitor).visitElseBranch(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElseBranchContext elseBranch() throws RecognitionException {
		ElseBranchContext _localctx = new ElseBranchContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_elseBranch);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(307);
			match(ELSE);
			setState(308);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LiteralContext extends ParserRuleContext {
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
	 
		public LiteralContext() { }
		public void copyFrom(LiteralContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class StringLiteralContext extends LiteralContext {
		public TerminalNode StringLiteral() { return getToken(ContinuityParser.StringLiteral, 0); }
		public StringLiteralContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ContinuityParserListener ) ((ContinuityParserListener)listener).enterStringLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ContinuityParserListener ) ((ContinuityParserListener)listener).exitStringLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ContinuityParserVisitor ) return ((ContinuityParserVisitor<? extends T>)visitor).visitStringLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FloatingPointLiteralContext extends LiteralContext {
		public TerminalNode FloatingPointLiteral() { return getToken(ContinuityParser.FloatingPointLiteral, 0); }
		public FloatingPointLiteralContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ContinuityParserListener ) ((ContinuityParserListener)listener).enterFloatingPointLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ContinuityParserListener ) ((ContinuityParserListener)listener).exitFloatingPointLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ContinuityParserVisitor ) return ((ContinuityParserVisitor<? extends T>)visitor).visitFloatingPointLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BooleanLiteralContext extends LiteralContext {
		public TerminalNode BooleanLiteral() { return getToken(ContinuityParser.BooleanLiteral, 0); }
		public BooleanLiteralContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ContinuityParserListener ) ((ContinuityParserListener)listener).enterBooleanLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ContinuityParserListener ) ((ContinuityParserListener)listener).exitBooleanLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ContinuityParserVisitor ) return ((ContinuityParserVisitor<? extends T>)visitor).visitBooleanLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NullLiteralContext extends LiteralContext {
		public TerminalNode NullLiteral() { return getToken(ContinuityParser.NullLiteral, 0); }
		public NullLiteralContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ContinuityParserListener ) ((ContinuityParserListener)listener).enterNullLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ContinuityParserListener ) ((ContinuityParserListener)listener).exitNullLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ContinuityParserVisitor ) return ((ContinuityParserVisitor<? extends T>)visitor).visitNullLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IntegerLiteralContext extends LiteralContext {
		public TerminalNode IntegerLiteral() { return getToken(ContinuityParser.IntegerLiteral, 0); }
		public IntegerLiteralContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ContinuityParserListener ) ((ContinuityParserListener)listener).enterIntegerLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ContinuityParserListener ) ((ContinuityParserListener)listener).exitIntegerLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ContinuityParserVisitor ) return ((ContinuityParserVisitor<? extends T>)visitor).visitIntegerLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CharacterLiteralContext extends LiteralContext {
		public TerminalNode CharacterLiteral() { return getToken(ContinuityParser.CharacterLiteral, 0); }
		public CharacterLiteralContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ContinuityParserListener ) ((ContinuityParserListener)listener).enterCharacterLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ContinuityParserListener ) ((ContinuityParserListener)listener).exitCharacterLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ContinuityParserVisitor ) return ((ContinuityParserVisitor<? extends T>)visitor).visitCharacterLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_literal);
		try {
			setState(316);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IntegerLiteral:
				_localctx = new IntegerLiteralContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(310);
				match(IntegerLiteral);
				}
				break;
			case FloatingPointLiteral:
				_localctx = new FloatingPointLiteralContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(311);
				match(FloatingPointLiteral);
				}
				break;
			case BooleanLiteral:
				_localctx = new BooleanLiteralContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(312);
				match(BooleanLiteral);
				}
				break;
			case CharacterLiteral:
				_localctx = new CharacterLiteralContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(313);
				match(CharacterLiteral);
				}
				break;
			case StringLiteral:
				_localctx = new StringLiteralContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(314);
				match(StringLiteral);
				}
				break;
			case NullLiteral:
				_localctx = new NullLiteralContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(315);
				match(NullLiteral);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 25:
			return booleanExpresion_sempred((BooleanExpresionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean booleanExpresion_sempred(BooleanExpresionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 3);
		case 1:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3@\u0141\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\3\2\3\2\3\2\7\2J\n\2\f\2\16\2M\13\2\3\2\3\2\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\5\3W\n\3\3\4\3\4\3\4\3\4\3\4\5\4^\n\4\3\4\3\4\3\4\5\4"+
		"c\n\4\3\5\3\5\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\6\7o\n\7\r\7\16\7p\3\7\3"+
		"\7\3\b\3\b\3\b\3\b\5\by\n\b\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\5\n\u0086\n\n\3\13\3\13\3\13\6\13\u008b\n\13\r\13\16\13\u008c\3\f\3"+
		"\f\3\f\3\f\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u009e"+
		"\n\16\3\17\3\17\6\17\u00a2\n\17\r\17\16\17\u00a3\3\20\3\20\3\20\3\20\3"+
		"\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\6\22\u00b4\n\22\r\22"+
		"\16\22\u00b5\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3"+
		"\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3"+
		"\23\3\23\3\23\3\23\5\23\u00d5\n\23\3\24\3\24\3\24\7\24\u00da\n\24\f\24"+
		"\16\24\u00dd\13\24\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\7\26\u00e7"+
		"\n\26\f\26\16\26\u00ea\13\26\5\26\u00ec\n\26\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\5\27\u00f4\n\27\3\30\5\30\u00f7\n\30\3\30\3\30\3\31\3\31\3\32\3"+
		"\32\6\32\u00ff\n\32\r\32\16\32\u0100\3\33\3\33\3\33\3\33\3\33\3\33\3\33"+
		"\3\33\5\33\u010b\n\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\7\33\u0115"+
		"\n\33\f\33\16\33\u0118\13\33\3\34\3\34\3\35\3\35\3\36\3\36\3\36\3\36\3"+
		"\36\5\36\u0123\n\36\3\37\3\37\7\37\u0127\n\37\f\37\16\37\u012a\13\37\3"+
		"\37\5\37\u012d\n\37\3 \3 \3 \3 \3!\3!\3!\3\"\3\"\3\"\3#\3#\3#\3#\3#\3"+
		"#\5#\u013f\n#\3#\2\3\64$\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&("+
		"*,.\60\62\64\668:<>@BD\2\6\3\2\n\23\3\2!\"\4\2\61\62;;\4\2&\'-\60\2\u014a"+
		"\2K\3\2\2\2\4V\3\2\2\2\6X\3\2\2\2\bd\3\2\2\2\nf\3\2\2\2\fj\3\2\2\2\16"+
		"t\3\2\2\2\20z\3\2\2\2\22\u0085\3\2\2\2\24\u008a\3\2\2\2\26\u008e\3\2\2"+
		"\2\30\u0092\3\2\2\2\32\u009d\3\2\2\2\34\u00a1\3\2\2\2\36\u00a5\3\2\2\2"+
		" \u00a9\3\2\2\2\"\u00af\3\2\2\2$\u00d4\3\2\2\2&\u00d6\3\2\2\2(\u00de\3"+
		"\2\2\2*\u00eb\3\2\2\2,\u00f3\3\2\2\2.\u00f6\3\2\2\2\60\u00fa\3\2\2\2\62"+
		"\u00fe\3\2\2\2\64\u010a\3\2\2\2\66\u0119\3\2\2\28\u011b\3\2\2\2:\u0122"+
		"\3\2\2\2<\u0124\3\2\2\2>\u012e\3\2\2\2@\u0132\3\2\2\2B\u0135\3\2\2\2D"+
		"\u013e\3\2\2\2FG\5\4\3\2GH\7 \2\2HJ\3\2\2\2IF\3\2\2\2JM\3\2\2\2KI\3\2"+
		"\2\2KL\3\2\2\2LN\3\2\2\2MK\3\2\2\2NO\7\2\2\3O\3\3\2\2\2PW\5 \21\2QW\5"+
		"$\23\2RW\5\22\n\2SW\5\32\16\2TW\5<\37\2UW\5\6\4\2VP\3\2\2\2VQ\3\2\2\2"+
		"VR\3\2\2\2VS\3\2\2\2VT\3\2\2\2VU\3\2\2\2W\5\3\2\2\2XY\7\t\2\2YZ\7=\2\2"+
		"Z]\7+\2\2[^\5\b\5\2\\^\5\n\6\2][\3\2\2\2]\\\3\2\2\2^_\3\2\2\2_b\7%\2\2"+
		"`c\5:\36\2ac\5\f\7\2b`\3\2\2\2ba\3\2\2\2c\7\3\2\2\2de\t\2\2\2e\t\3\2\2"+
		"\2fg\5\b\5\2gh\7\36\2\2hi\7\37\2\2i\13\3\2\2\2jn\7\34\2\2kl\5\4\3\2lm"+
		"\7#\2\2mo\3\2\2\2nk\3\2\2\2op\3\2\2\2pn\3\2\2\2pq\3\2\2\2qr\3\2\2\2rs"+
		"\7\35\2\2s\r\3\2\2\2tu\7\t\2\2uv\7!\2\2vx\7=\2\2wy\5\20\t\2xw\3\2\2\2"+
		"xy\3\2\2\2y\17\3\2\2\2z{\7\36\2\2{|\7\24\2\2|}\7\37\2\2}\21\3\2\2\2~\177"+
		"\7\4\2\2\177\u0086\5.\30\2\u0080\u0081\7\4\2\2\u0081\u0082\7\34\2\2\u0082"+
		"\u0083\5\24\13\2\u0083\u0084\7\35\2\2\u0084\u0086\3\2\2\2\u0085~\3\2\2"+
		"\2\u0085\u0080\3\2\2\2\u0086\23\3\2\2\2\u0087\u0088\5.\30\2\u0088\u0089"+
		"\7 \2\2\u0089\u008b\3\2\2\2\u008a\u0087\3\2\2\2\u008b\u008c\3\2\2\2\u008c"+
		"\u008a\3\2\2\2\u008c\u008d\3\2\2\2\u008d\25\3\2\2\2\u008e\u008f\7\4\2"+
		"\2\u008f\u0090\7,\2\2\u0090\u0091\7=\2\2\u0091\27\3\2\2\2\u0092\u0093"+
		"\5\26\f\2\u0093\u0094\7!\2\2\u0094\u0095\7=\2\2\u0095\31\3\2\2\2\u0096"+
		"\u0097\7\3\2\2\u0097\u009e\7=\2\2\u0098\u0099\7\3\2\2\u0099\u009a\7\34"+
		"\2\2\u009a\u009b\5\34\17\2\u009b\u009c\7\35\2\2\u009c\u009e\3\2\2\2\u009d"+
		"\u0096\3\2\2\2\u009d\u0098\3\2\2\2\u009e\33\3\2\2\2\u009f\u00a0\7=\2\2"+
		"\u00a0\u00a2\7 \2\2\u00a1\u009f\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3\u00a1"+
		"\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4\35\3\2\2\2\u00a5\u00a6\7\3\2\2\u00a6"+
		"\u00a7\7,\2\2\u00a7\u00a8\7=\2\2\u00a8\37\3\2\2\2\u00a9\u00aa\7\5\2\2"+
		"\u00aa\u00ab\7=\2\2\u00ab\u00ac\7\32\2\2\u00ac\u00ad\7\33\2\2\u00ad\u00ae"+
		"\5\"\22\2\u00ae!\3\2\2\2\u00af\u00b3\7\34\2\2\u00b0\u00b1\5\4\3\2\u00b1"+
		"\u00b2\7 \2\2\u00b2\u00b4\3\2\2\2\u00b3\u00b0\3\2\2\2\u00b4\u00b5\3\2"+
		"\2\2\u00b5\u00b3\3\2\2\2\u00b5\u00b6\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7"+
		"\u00b8\7\35\2\2\u00b8#\3\2\2\2\u00b9\u00ba\7\6\2\2\u00ba\u00bb\7,\2\2"+
		"\u00bb\u00bc\5\60\31\2\u00bc\u00bd\7\32\2\2\u00bd\u00be\5*\26\2\u00be"+
		"\u00bf\7\33\2\2\u00bf\u00d5\3\2\2\2\u00c0\u00c1\7\5\2\2\u00c1\u00c2\7"+
		"!\2\2\u00c2\u00c3\5\60\31\2\u00c3\u00c4\7\32\2\2\u00c4\u00c5\7\33\2\2"+
		"\u00c5\u00d5\3\2\2\2\u00c6\u00c7\5\26\f\2\u00c7\u00c8\7$\2\2\u00c8\u00c9"+
		"\5&\24\2\u00c9\u00d5\3\2\2\2\u00ca\u00cb\5\36\20\2\u00cb\u00cc\7$\2\2"+
		"\u00cc\u00cd\5&\24\2\u00cd\u00d5\3\2\2\2\u00ce\u00cf\5\30\r\2\u00cf\u00d0"+
		"\7$\2\2\u00d0\u00d1\5\60\31\2\u00d1\u00d2\7\32\2\2\u00d2\u00d3\7\33\2"+
		"\2\u00d3\u00d5\3\2\2\2\u00d4\u00b9\3\2\2\2\u00d4\u00c0\3\2\2\2\u00d4\u00c6"+
		"\3\2\2\2\u00d4\u00ca\3\2\2\2\u00d4\u00ce\3\2\2\2\u00d5%\3\2\2\2\u00d6"+
		"\u00db\5(\25\2\u00d7\u00d8\7!\2\2\u00d8\u00da\5(\25\2\u00d9\u00d7\3\2"+
		"\2\2\u00da\u00dd\3\2\2\2\u00db\u00d9\3\2\2\2\u00db\u00dc\3\2\2\2\u00dc"+
		"\'\3\2\2\2\u00dd\u00db\3\2\2\2\u00de\u00df\5\60\31\2\u00df\u00e0\7\32"+
		"\2\2\u00e0\u00e1\5*\26\2\u00e1\u00e2\7\33\2\2\u00e2)\3\2\2\2\u00e3\u00e8"+
		"\5,\27\2\u00e4\u00e5\7#\2\2\u00e5\u00e7\5,\27\2\u00e6\u00e4\3\2\2\2\u00e7"+
		"\u00ea\3\2\2\2\u00e8\u00e6\3\2\2\2\u00e8\u00e9\3\2\2\2\u00e9\u00ec\3\2"+
		"\2\2\u00ea\u00e8\3\2\2\2\u00eb\u00e3\3\2\2\2\u00eb\u00ec\3\2\2\2\u00ec"+
		"+\3\2\2\2\u00ed\u00f4\5D#\2\u00ee\u00f4\5\36\20\2\u00ef\u00f4\5$\23\2"+
		"\u00f0\u00f4\5\30\r\2\u00f1\u00f4\5\64\33\2\u00f2\u00f4\5\16\b\2\u00f3"+
		"\u00ed\3\2\2\2\u00f3\u00ee\3\2\2\2\u00f3\u00ef\3\2\2\2\u00f3\u00f0\3\2"+
		"\2\2\u00f3\u00f1\3\2\2\2\u00f3\u00f2\3\2\2\2\u00f4-\3\2\2\2\u00f5\u00f7"+
		"\5\62\32\2\u00f6\u00f5\3\2\2\2\u00f6\u00f7\3\2\2\2\u00f7\u00f8\3\2\2\2"+
		"\u00f8\u00f9\5\60\31\2\u00f9/\3\2\2\2\u00fa\u00fb\7=\2\2\u00fb\61\3\2"+
		"\2\2\u00fc\u00fd\7=\2\2\u00fd\u00ff\t\3\2\2\u00fe\u00fc\3\2\2\2\u00ff"+
		"\u0100\3\2\2\2\u0100\u00fe\3\2\2\2\u0100\u0101\3\2\2\2\u0101\63\3\2\2"+
		"\2\u0102\u0103\b\33\1\2\u0103\u0104\7\32\2\2\u0104\u0105\5\64\33\2\u0105"+
		"\u0106\7\33\2\2\u0106\u010b\3\2\2\2\u0107\u0108\7(\2\2\u0108\u010b\5\64"+
		"\33\6\u0109\u010b\5:\36\2\u010a\u0102\3\2\2\2\u010a\u0107\3\2\2\2\u010a"+
		"\u0109\3\2\2\2\u010b\u0116\3\2\2\2\u010c\u010d\f\5\2\2\u010d\u010e\58"+
		"\35\2\u010e\u010f\5\64\33\6\u010f\u0115\3\2\2\2\u0110\u0111\f\4\2\2\u0111"+
		"\u0112\5\66\34\2\u0112\u0113\5\64\33\5\u0113\u0115\3\2\2\2\u0114\u010c"+
		"\3\2\2\2\u0114\u0110\3\2\2\2\u0115\u0118\3\2\2\2\u0116\u0114\3\2\2\2\u0116"+
		"\u0117\3\2\2\2\u0117\65\3\2\2\2\u0118\u0116\3\2\2\2\u0119\u011a\t\4\2"+
		"\2\u011a\67\3\2\2\2\u011b\u011c\t\5\2\2\u011c9\3\2\2\2\u011d\u0123\5\26"+
		"\f\2\u011e\u0123\5\36\20\2\u011f\u0123\5$\23\2\u0120\u0123\5D#\2\u0121"+
		"\u0123\5\16\b\2\u0122\u011d\3\2\2\2\u0122\u011e\3\2\2\2\u0122\u011f\3"+
		"\2\2\2\u0122\u0120\3\2\2\2\u0122\u0121\3\2\2\2\u0123;\3\2\2\2\u0124\u0128"+
		"\5> \2\u0125\u0127\5@!\2\u0126\u0125\3\2\2\2\u0127\u012a\3\2\2\2\u0128"+
		"\u0126\3\2\2\2\u0128\u0129\3\2\2\2\u0129\u012c\3\2\2\2\u012a\u0128\3\2"+
		"\2\2\u012b\u012d\5B\"\2\u012c\u012b\3\2\2\2\u012c\u012d\3\2\2\2\u012d"+
		"=\3\2\2\2\u012e\u012f\7\7\2\2\u012f\u0130\5\64\33\2\u0130\u0131\5\"\22"+
		"\2\u0131?\3\2\2\2\u0132\u0133\7\b\2\2\u0133\u0134\5> \2\u0134A\3\2\2\2"+
		"\u0135\u0136\7\b\2\2\u0136\u0137\5\"\22\2\u0137C\3\2\2\2\u0138\u013f\7"+
		"\24\2\2\u0139\u013f\7\25\2\2\u013a\u013f\7\26\2\2\u013b\u013f\7\27\2\2"+
		"\u013c\u013f\7\30\2\2\u013d\u013f\7\31\2\2\u013e\u0138\3\2\2\2\u013e\u0139"+
		"\3\2\2\2\u013e\u013a\3\2\2\2\u013e\u013b\3\2\2\2\u013e\u013c\3\2\2\2\u013e"+
		"\u013d\3\2\2\2\u013fE\3\2\2\2\33KV]bpx\u0085\u008c\u009d\u00a3\u00b5\u00d4"+
		"\u00db\u00e8\u00eb\u00f3\u00f6\u0100\u010a\u0114\u0116\u0122\u0128\u012c"+
		"\u013e";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}