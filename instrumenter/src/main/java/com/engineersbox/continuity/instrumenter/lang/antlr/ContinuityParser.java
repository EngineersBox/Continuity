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
		RULE_variableReference = 4, RULE_externalLayout = 5, RULE_externalEntries = 6, 
		RULE_externalEntryReference = 7, RULE_externalEntryEnumConstantReference = 8, 
		RULE_contextLayout = 9, RULE_contextEntries = 10, RULE_contextEntryReference = 11, 
		RULE_function = 12, RULE_block = 13, RULE_invocation = 14, RULE_methodInvocationChain = 15, 
		RULE_methodInvocation = 16, RULE_params = 17, RULE_param = 18, RULE_reference = 19, 
		RULE_referenceTarget = 20, RULE_referenceChain = 21, RULE_booleanExpresion = 22, 
		RULE_comparisonJoin = 23, RULE_comparator = 24, RULE_valueTarget = 25, 
		RULE_ifCondition = 26, RULE_ifBranch = 27, RULE_elseIfBranch = 28, RULE_elseBranch = 29, 
		RULE_literal = 30;
	public static final String[] ruleNames = {
		"parse", "statement", "variableDeclaration", "variableType", "variableReference", 
		"externalLayout", "externalEntries", "externalEntryReference", "externalEntryEnumConstantReference", 
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
			setState(67);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CTX) | (1L << EXT) | (1L << FN) | (1L << STD) | (1L << IF) | (1L << LET))) != 0)) {
				{
				{
				setState(62);
				statement();
				setState(63);
				match(SEMI);
				}
				}
				setState(69);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(70);
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
			setState(78);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				_localctx = new FunctionStatementContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(72);
				function();
				}
				break;
			case 2:
				_localctx = new InvocationStatementContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(73);
				invocation();
				}
				break;
			case 3:
				_localctx = new ExternalLayoutStatementContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(74);
				externalLayout();
				}
				break;
			case 4:
				_localctx = new ContextLayoutStatementContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(75);
				contextLayout();
				}
				break;
			case 5:
				_localctx = new IfStatementContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(76);
				ifCondition();
				}
				break;
			case 6:
				_localctx = new VariableDeclarationStatementContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(77);
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
		public VariableTypeContext variableType() {
			return getRuleContext(VariableTypeContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(ContinuityParser.ASSIGN, 0); }
		public ValueTargetContext valueTarget() {
			return getRuleContext(ValueTargetContext.class,0);
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
			setState(80);
			match(LET);
			setState(81);
			match(Identifier);
			setState(82);
			match(COLON);
			setState(83);
			variableType();
			setState(84);
			match(ASSIGN);
			setState(85);
			valueTarget();
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
			setState(87);
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

	public static class VariableReferenceContext extends ParserRuleContext {
		public TerminalNode LET() { return getToken(ContinuityParser.LET, 0); }
		public TerminalNode DOT() { return getToken(ContinuityParser.DOT, 0); }
		public TerminalNode Identifier() { return getToken(ContinuityParser.Identifier, 0); }
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
		enterRule(_localctx, 8, RULE_variableReference);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(89);
			match(LET);
			setState(90);
			match(DOT);
			setState(91);
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
		enterRule(_localctx, 10, RULE_externalLayout);
		try {
			setState(100);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				_localctx = new SingleExternalLayoutDeclarationContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(93);
				match(EXT);
				setState(94);
				reference();
				}
				break;
			case 2:
				_localctx = new MultiExternalLayoutDeclarationContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(95);
				match(EXT);
				setState(96);
				match(LBRACE);
				setState(97);
				externalEntries();
				setState(98);
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
		enterRule(_localctx, 12, RULE_externalEntries);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(105); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(102);
				reference();
				setState(103);
				match(SEMI);
				}
				}
				setState(107); 
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
		enterRule(_localctx, 14, RULE_externalEntryReference);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(109);
			match(EXT);
			setState(110);
			match(COLONCOLON);
			setState(111);
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
		enterRule(_localctx, 16, RULE_externalEntryEnumConstantReference);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(113);
			externalEntryReference();
			setState(114);
			match(DOT);
			setState(115);
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
		enterRule(_localctx, 18, RULE_contextLayout);
		try {
			setState(124);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				_localctx = new SingleContextLayoutDeclarationContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(117);
				match(CTX);
				setState(118);
				match(Identifier);
				}
				break;
			case 2:
				_localctx = new MultiContextLayoutDeclarationContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(119);
				match(CTX);
				setState(120);
				match(LBRACE);
				setState(121);
				contextEntries();
				setState(122);
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
		enterRule(_localctx, 20, RULE_contextEntries);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(128); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(126);
				match(Identifier);
				setState(127);
				match(SEMI);
				}
				}
				setState(130); 
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
		enterRule(_localctx, 22, RULE_contextEntryReference);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(132);
			match(CTX);
			setState(133);
			match(COLONCOLON);
			setState(134);
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
		enterRule(_localctx, 24, RULE_function);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(136);
			match(FN);
			setState(137);
			match(Identifier);
			setState(138);
			match(LPAREN);
			setState(139);
			match(RPAREN);
			setState(140);
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
		enterRule(_localctx, 26, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(142);
			match(LBRACE);
			setState(146); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(143);
				statement();
				setState(144);
				match(SEMI);
				}
				}
				setState(148); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CTX) | (1L << EXT) | (1L << FN) | (1L << STD) | (1L << IF) | (1L << LET))) != 0) );
			setState(150);
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
		enterRule(_localctx, 28, RULE_invocation);
		try {
			setState(179);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				_localctx = new StdInvocationContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(152);
				match(STD);
				setState(153);
				match(COLONCOLON);
				setState(154);
				referenceTarget();
				setState(155);
				match(LPAREN);
				setState(156);
				params();
				setState(157);
				match(RPAREN);
				}
				break;
			case 2:
				_localctx = new FunctionInvocationContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(159);
				match(FN);
				setState(160);
				match(DOT);
				setState(161);
				referenceTarget();
				setState(162);
				match(LPAREN);
				setState(163);
				match(RPAREN);
				}
				break;
			case 3:
				_localctx = new ExternalReferenceInvocationContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(165);
				externalEntryReference();
				setState(166);
				match(ARROW);
				setState(167);
				methodInvocationChain();
				}
				break;
			case 4:
				_localctx = new ContextReferenceInvocationContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(169);
				contextEntryReference();
				setState(170);
				match(ARROW);
				setState(171);
				methodInvocationChain();
				}
				break;
			case 5:
				_localctx = new EnumConstantMethodInvocationParamContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(173);
				externalEntryEnumConstantReference();
				setState(174);
				match(ARROW);
				setState(175);
				referenceTarget();
				setState(176);
				match(LPAREN);
				setState(177);
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
		enterRule(_localctx, 30, RULE_methodInvocationChain);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(181);
			methodInvocation();
			setState(186);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(182);
					match(DOT);
					setState(183);
					methodInvocation();
					}
					} 
				}
				setState(188);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
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
		enterRule(_localctx, 32, RULE_methodInvocation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(189);
			referenceTarget();
			setState(190);
			match(LPAREN);
			setState(191);
			params();
			setState(192);
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
		enterRule(_localctx, 34, RULE_params);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(202);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CTX) | (1L << EXT) | (1L << FN) | (1L << STD) | (1L << LET) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << NullLiteral) | (1L << LPAREN) | (1L << BANG))) != 0)) {
				{
				setState(194);
				param();
				setState(199);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(195);
					match(COMMA);
					setState(196);
					param();
					}
					}
					setState(201);
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
		enterRule(_localctx, 36, RULE_param);
		try {
			setState(210);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				_localctx = new LiteralParamContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(204);
				literal();
				}
				break;
			case 2:
				_localctx = new ContextEntryReferenceParamContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(205);
				contextEntryReference();
				}
				break;
			case 3:
				_localctx = new InvocationParamContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(206);
				invocation();
				}
				break;
			case 4:
				_localctx = new EnumConstantReferenceParamContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(207);
				externalEntryEnumConstantReference();
				}
				break;
			case 5:
				_localctx = new BooleanExpressionParamContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(208);
				booleanExpresion(0);
				}
				break;
			case 6:
				_localctx = new VariableReferenceParamContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(209);
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
		enterRule(_localctx, 38, RULE_reference);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(213);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				{
				setState(212);
				referenceChain();
				}
				break;
			}
			setState(215);
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
		enterRule(_localctx, 40, RULE_referenceTarget);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(217);
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
		enterRule(_localctx, 42, RULE_referenceChain);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(221); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(219);
					match(Identifier);
					setState(220);
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
				setState(223); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
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
		int _startState = 44;
		enterRecursionRule(_localctx, 44, RULE_booleanExpresion, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(233);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LPAREN:
				{
				_localctx = new ParenBooleanExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(226);
				match(LPAREN);
				setState(227);
				booleanExpresion(0);
				setState(228);
				match(RPAREN);
				}
				break;
			case BANG:
				{
				_localctx = new NegationBooleanExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(230);
				match(BANG);
				setState(231);
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
				setState(232);
				valueTarget();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(245);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(243);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
					case 1:
						{
						_localctx = new ComparatorBooleanExpressionContext(new BooleanExpresionContext(_parentctx, _parentState));
						((ComparatorBooleanExpressionContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_booleanExpresion);
						setState(235);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(236);
						comparator();
						setState(237);
						((ComparatorBooleanExpressionContext)_localctx).right = booleanExpresion(4);
						}
						break;
					case 2:
						{
						_localctx = new BinaryBooleanExpressionContext(new BooleanExpresionContext(_parentctx, _parentState));
						((BinaryBooleanExpressionContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_booleanExpresion);
						setState(239);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(240);
						comparisonJoin();
						setState(241);
						((BinaryBooleanExpressionContext)_localctx).right = booleanExpresion(3);
						}
						break;
					}
					} 
				}
				setState(247);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
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
		enterRule(_localctx, 46, RULE_comparisonJoin);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(248);
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
		enterRule(_localctx, 48, RULE_comparator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(250);
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
		enterRule(_localctx, 50, RULE_valueTarget);
		try {
			setState(257);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(252);
				externalEntryReference();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(253);
				contextEntryReference();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(254);
				invocation();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(255);
				literal();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(256);
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
		enterRule(_localctx, 52, RULE_ifCondition);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(259);
			ifBranch();
			setState(263);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(260);
					elseIfBranch();
					}
					} 
				}
				setState(265);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			}
			setState(267);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(266);
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
		enterRule(_localctx, 54, RULE_ifBranch);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(269);
			match(IF);
			setState(270);
			booleanExpresion(0);
			setState(271);
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
		enterRule(_localctx, 56, RULE_elseIfBranch);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(273);
			match(ELSE);
			setState(274);
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
		enterRule(_localctx, 58, RULE_elseBranch);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(276);
			match(ELSE);
			setState(277);
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
		enterRule(_localctx, 60, RULE_literal);
		try {
			setState(285);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IntegerLiteral:
				_localctx = new IntegerLiteralContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(279);
				match(IntegerLiteral);
				}
				break;
			case FloatingPointLiteral:
				_localctx = new FloatingPointLiteralContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(280);
				match(FloatingPointLiteral);
				}
				break;
			case BooleanLiteral:
				_localctx = new BooleanLiteralContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(281);
				match(BooleanLiteral);
				}
				break;
			case CharacterLiteral:
				_localctx = new CharacterLiteralContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(282);
				match(CharacterLiteral);
				}
				break;
			case StringLiteral:
				_localctx = new StringLiteralContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(283);
				match(StringLiteral);
				}
				break;
			case NullLiteral:
				_localctx = new NullLiteralContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(284);
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
		case 22:
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3@\u0122\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \3\2"+
		"\3\2\3\2\7\2D\n\2\f\2\16\2G\13\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\5\3Q"+
		"\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\5\7g\n\7\3\b\3\b\3\b\6\bl\n\b\r\b\16\bm\3\t\3\t\3\t\3\t"+
		"\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\177\n\13\3\f"+
		"\3\f\6\f\u0083\n\f\r\f\16\f\u0084\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\17\3\17\3\17\3\17\6\17\u0095\n\17\r\17\16\17\u0096\3\17\3"+
		"\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3"+
		"\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5"+
		"\20\u00b6\n\20\3\21\3\21\3\21\7\21\u00bb\n\21\f\21\16\21\u00be\13\21\3"+
		"\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\7\23\u00c8\n\23\f\23\16\23\u00cb"+
		"\13\23\5\23\u00cd\n\23\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u00d5\n\24\3"+
		"\25\5\25\u00d8\n\25\3\25\3\25\3\26\3\26\3\27\3\27\6\27\u00e0\n\27\r\27"+
		"\16\27\u00e1\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\5\30\u00ec\n\30\3"+
		"\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\7\30\u00f6\n\30\f\30\16\30\u00f9"+
		"\13\30\3\31\3\31\3\32\3\32\3\33\3\33\3\33\3\33\3\33\5\33\u0104\n\33\3"+
		"\34\3\34\7\34\u0108\n\34\f\34\16\34\u010b\13\34\3\34\5\34\u010e\n\34\3"+
		"\35\3\35\3\35\3\35\3\36\3\36\3\36\3\37\3\37\3\37\3 \3 \3 \3 \3 \3 \5 "+
		"\u0120\n \3 \2\3.!\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60"+
		"\62\64\668:<>\2\6\3\2\n\23\3\2!\"\4\2\61\62;;\4\2&\'-\60\2\u012a\2E\3"+
		"\2\2\2\4P\3\2\2\2\6R\3\2\2\2\bY\3\2\2\2\n[\3\2\2\2\ff\3\2\2\2\16k\3\2"+
		"\2\2\20o\3\2\2\2\22s\3\2\2\2\24~\3\2\2\2\26\u0082\3\2\2\2\30\u0086\3\2"+
		"\2\2\32\u008a\3\2\2\2\34\u0090\3\2\2\2\36\u00b5\3\2\2\2 \u00b7\3\2\2\2"+
		"\"\u00bf\3\2\2\2$\u00cc\3\2\2\2&\u00d4\3\2\2\2(\u00d7\3\2\2\2*\u00db\3"+
		"\2\2\2,\u00df\3\2\2\2.\u00eb\3\2\2\2\60\u00fa\3\2\2\2\62\u00fc\3\2\2\2"+
		"\64\u0103\3\2\2\2\66\u0105\3\2\2\28\u010f\3\2\2\2:\u0113\3\2\2\2<\u0116"+
		"\3\2\2\2>\u011f\3\2\2\2@A\5\4\3\2AB\7 \2\2BD\3\2\2\2C@\3\2\2\2DG\3\2\2"+
		"\2EC\3\2\2\2EF\3\2\2\2FH\3\2\2\2GE\3\2\2\2HI\7\2\2\3I\3\3\2\2\2JQ\5\32"+
		"\16\2KQ\5\36\20\2LQ\5\f\7\2MQ\5\24\13\2NQ\5\66\34\2OQ\5\6\4\2PJ\3\2\2"+
		"\2PK\3\2\2\2PL\3\2\2\2PM\3\2\2\2PN\3\2\2\2PO\3\2\2\2Q\5\3\2\2\2RS\7\t"+
		"\2\2ST\7=\2\2TU\7+\2\2UV\5\b\5\2VW\7%\2\2WX\5\64\33\2X\7\3\2\2\2YZ\t\2"+
		"\2\2Z\t\3\2\2\2[\\\7\t\2\2\\]\7!\2\2]^\7=\2\2^\13\3\2\2\2_`\7\4\2\2`g"+
		"\5(\25\2ab\7\4\2\2bc\7\34\2\2cd\5\16\b\2de\7\35\2\2eg\3\2\2\2f_\3\2\2"+
		"\2fa\3\2\2\2g\r\3\2\2\2hi\5(\25\2ij\7 \2\2jl\3\2\2\2kh\3\2\2\2lm\3\2\2"+
		"\2mk\3\2\2\2mn\3\2\2\2n\17\3\2\2\2op\7\4\2\2pq\7,\2\2qr\7=\2\2r\21\3\2"+
		"\2\2st\5\20\t\2tu\7!\2\2uv\7=\2\2v\23\3\2\2\2wx\7\3\2\2x\177\7=\2\2yz"+
		"\7\3\2\2z{\7\34\2\2{|\5\26\f\2|}\7\35\2\2}\177\3\2\2\2~w\3\2\2\2~y\3\2"+
		"\2\2\177\25\3\2\2\2\u0080\u0081\7=\2\2\u0081\u0083\7 \2\2\u0082\u0080"+
		"\3\2\2\2\u0083\u0084\3\2\2\2\u0084\u0082\3\2\2\2\u0084\u0085\3\2\2\2\u0085"+
		"\27\3\2\2\2\u0086\u0087\7\3\2\2\u0087\u0088\7,\2\2\u0088\u0089\7=\2\2"+
		"\u0089\31\3\2\2\2\u008a\u008b\7\5\2\2\u008b\u008c\7=\2\2\u008c\u008d\7"+
		"\32\2\2\u008d\u008e\7\33\2\2\u008e\u008f\5\34\17\2\u008f\33\3\2\2\2\u0090"+
		"\u0094\7\34\2\2\u0091\u0092\5\4\3\2\u0092\u0093\7 \2\2\u0093\u0095\3\2"+
		"\2\2\u0094\u0091\3\2\2\2\u0095\u0096\3\2\2\2\u0096\u0094\3\2\2\2\u0096"+
		"\u0097\3\2\2\2\u0097\u0098\3\2\2\2\u0098\u0099\7\35\2\2\u0099\35\3\2\2"+
		"\2\u009a\u009b\7\6\2\2\u009b\u009c\7,\2\2\u009c\u009d\5*\26\2\u009d\u009e"+
		"\7\32\2\2\u009e\u009f\5$\23\2\u009f\u00a0\7\33\2\2\u00a0\u00b6\3\2\2\2"+
		"\u00a1\u00a2\7\5\2\2\u00a2\u00a3\7!\2\2\u00a3\u00a4\5*\26\2\u00a4\u00a5"+
		"\7\32\2\2\u00a5\u00a6\7\33\2\2\u00a6\u00b6\3\2\2\2\u00a7\u00a8\5\20\t"+
		"\2\u00a8\u00a9\7$\2\2\u00a9\u00aa\5 \21\2\u00aa\u00b6\3\2\2\2\u00ab\u00ac"+
		"\5\30\r\2\u00ac\u00ad\7$\2\2\u00ad\u00ae\5 \21\2\u00ae\u00b6\3\2\2\2\u00af"+
		"\u00b0\5\22\n\2\u00b0\u00b1\7$\2\2\u00b1\u00b2\5*\26\2\u00b2\u00b3\7\32"+
		"\2\2\u00b3\u00b4\7\33\2\2\u00b4\u00b6\3\2\2\2\u00b5\u009a\3\2\2\2\u00b5"+
		"\u00a1\3\2\2\2\u00b5\u00a7\3\2\2\2\u00b5\u00ab\3\2\2\2\u00b5\u00af\3\2"+
		"\2\2\u00b6\37\3\2\2\2\u00b7\u00bc\5\"\22\2\u00b8\u00b9\7!\2\2\u00b9\u00bb"+
		"\5\"\22\2\u00ba\u00b8\3\2\2\2\u00bb\u00be\3\2\2\2\u00bc\u00ba\3\2\2\2"+
		"\u00bc\u00bd\3\2\2\2\u00bd!\3\2\2\2\u00be\u00bc\3\2\2\2\u00bf\u00c0\5"+
		"*\26\2\u00c0\u00c1\7\32\2\2\u00c1\u00c2\5$\23\2\u00c2\u00c3\7\33\2\2\u00c3"+
		"#\3\2\2\2\u00c4\u00c9\5&\24\2\u00c5\u00c6\7#\2\2\u00c6\u00c8\5&\24\2\u00c7"+
		"\u00c5\3\2\2\2\u00c8\u00cb\3\2\2\2\u00c9\u00c7\3\2\2\2\u00c9\u00ca\3\2"+
		"\2\2\u00ca\u00cd\3\2\2\2\u00cb\u00c9\3\2\2\2\u00cc\u00c4\3\2\2\2\u00cc"+
		"\u00cd\3\2\2\2\u00cd%\3\2\2\2\u00ce\u00d5\5> \2\u00cf\u00d5\5\30\r\2\u00d0"+
		"\u00d5\5\36\20\2\u00d1\u00d5\5\22\n\2\u00d2\u00d5\5.\30\2\u00d3\u00d5"+
		"\5\n\6\2\u00d4\u00ce\3\2\2\2\u00d4\u00cf\3\2\2\2\u00d4\u00d0\3\2\2\2\u00d4"+
		"\u00d1\3\2\2\2\u00d4\u00d2\3\2\2\2\u00d4\u00d3\3\2\2\2\u00d5\'\3\2\2\2"+
		"\u00d6\u00d8\5,\27\2\u00d7\u00d6\3\2\2\2\u00d7\u00d8\3\2\2\2\u00d8\u00d9"+
		"\3\2\2\2\u00d9\u00da\5*\26\2\u00da)\3\2\2\2\u00db\u00dc\7=\2\2\u00dc+"+
		"\3\2\2\2\u00dd\u00de\7=\2\2\u00de\u00e0\t\3\2\2\u00df\u00dd\3\2\2\2\u00e0"+
		"\u00e1\3\2\2\2\u00e1\u00df\3\2\2\2\u00e1\u00e2\3\2\2\2\u00e2-\3\2\2\2"+
		"\u00e3\u00e4\b\30\1\2\u00e4\u00e5\7\32\2\2\u00e5\u00e6\5.\30\2\u00e6\u00e7"+
		"\7\33\2\2\u00e7\u00ec\3\2\2\2\u00e8\u00e9\7(\2\2\u00e9\u00ec\5.\30\6\u00ea"+
		"\u00ec\5\64\33\2\u00eb\u00e3\3\2\2\2\u00eb\u00e8\3\2\2\2\u00eb\u00ea\3"+
		"\2\2\2\u00ec\u00f7\3\2\2\2\u00ed\u00ee\f\5\2\2\u00ee\u00ef\5\62\32\2\u00ef"+
		"\u00f0\5.\30\6\u00f0\u00f6\3\2\2\2\u00f1\u00f2\f\4\2\2\u00f2\u00f3\5\60"+
		"\31\2\u00f3\u00f4\5.\30\5\u00f4\u00f6\3\2\2\2\u00f5\u00ed\3\2\2\2\u00f5"+
		"\u00f1\3\2\2\2\u00f6\u00f9\3\2\2\2\u00f7\u00f5\3\2\2\2\u00f7\u00f8\3\2"+
		"\2\2\u00f8/\3\2\2\2\u00f9\u00f7\3\2\2\2\u00fa\u00fb\t\4\2\2\u00fb\61\3"+
		"\2\2\2\u00fc\u00fd\t\5\2\2\u00fd\63\3\2\2\2\u00fe\u0104\5\20\t\2\u00ff"+
		"\u0104\5\30\r\2\u0100\u0104\5\36\20\2\u0101\u0104\5> \2\u0102\u0104\5"+
		"\n\6\2\u0103\u00fe\3\2\2\2\u0103\u00ff\3\2\2\2\u0103\u0100\3\2\2\2\u0103"+
		"\u0101\3\2\2\2\u0103\u0102\3\2\2\2\u0104\65\3\2\2\2\u0105\u0109\58\35"+
		"\2\u0106\u0108\5:\36\2\u0107\u0106\3\2\2\2\u0108\u010b\3\2\2\2\u0109\u0107"+
		"\3\2\2\2\u0109\u010a\3\2\2\2\u010a\u010d\3\2\2\2\u010b\u0109\3\2\2\2\u010c"+
		"\u010e\5<\37\2\u010d\u010c\3\2\2\2\u010d\u010e\3\2\2\2\u010e\67\3\2\2"+
		"\2\u010f\u0110\7\7\2\2\u0110\u0111\5.\30\2\u0111\u0112\5\34\17\2\u0112"+
		"9\3\2\2\2\u0113\u0114\7\b\2\2\u0114\u0115\58\35\2\u0115;\3\2\2\2\u0116"+
		"\u0117\7\b\2\2\u0117\u0118\5\34\17\2\u0118=\3\2\2\2\u0119\u0120\7\24\2"+
		"\2\u011a\u0120\7\25\2\2\u011b\u0120\7\26\2\2\u011c\u0120\7\27\2\2\u011d"+
		"\u0120\7\30\2\2\u011e\u0120\7\31\2\2\u011f\u0119\3\2\2\2\u011f\u011a\3"+
		"\2\2\2\u011f\u011b\3\2\2\2\u011f\u011c\3\2\2\2\u011f\u011d\3\2\2\2\u011f"+
		"\u011e\3\2\2\2\u0120?\3\2\2\2\27EPfm~\u0084\u0096\u00b5\u00bc\u00c9\u00cc"+
		"\u00d4\u00d7\u00e1\u00eb\u00f5\u00f7\u0103\u0109\u010d\u011f";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}