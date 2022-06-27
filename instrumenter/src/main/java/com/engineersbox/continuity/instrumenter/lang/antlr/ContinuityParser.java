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
		CTX=1, EXT=2, FN=3, STD=4, IntegerLiteral=5, FloatingPointLiteral=6, BooleanLiteral=7, 
		CharacterLiteral=8, StringLiteral=9, NullLiteral=10, LPAREN=11, RPAREN=12, 
		LBRACE=13, RBRACE=14, LBRACK=15, RBRACK=16, SEMI=17, DOT=18, COMMA=19, 
		ASSIGN=20, GT=21, LT=22, BANG=23, TILDE=24, QUESTION=25, COLON=26, COLONCOLON=27, 
		EQUAL=28, LE=29, GE=30, NOTEQUAL=31, AND=32, OR=33, INC=34, DEC=35, ADD=36, 
		SUB=37, MUL=38, DIV=39, BITAND=40, BITOR=41, CARET=42, MOD=43, Identifier=44, 
		WS=45, COMMENT=46, LINE_COMMENT=47;
	public static final int
		RULE_parse = 0, RULE_statement = 1, RULE_externalLayout = 2, RULE_externalEntries = 3, 
		RULE_externalEntryReference = 4, RULE_contextLayout = 5, RULE_contextEntries = 6, 
		RULE_contextEntryReference = 7, RULE_function = 8, RULE_block = 9, RULE_statements = 10, 
		RULE_invocation = 11, RULE_params = 12, RULE_param = 13, RULE_reference = 14, 
		RULE_referenceTarget = 15, RULE_referenceChain = 16, RULE_literal = 17;
	public static final String[] ruleNames = {
		"parse", "statement", "externalLayout", "externalEntries", "externalEntryReference", 
		"contextLayout", "contextEntries", "contextEntryReference", "function", 
		"block", "statements", "invocation", "params", "param", "reference", "referenceTarget", 
		"referenceChain", "literal"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'ctx'", "'ext'", "'fn'", "'std'", null, null, null, null, null, 
		"'null'", "'('", "')'", "'{'", "'}'", "'['", "']'", "';'", "'.'", "','", 
		"'='", "'>'", "'<'", "'!'", "'~'", "'?'", "':'", "'::'", "'=='", "'<='", 
		"'>='", "'!='", "'&&'", "'||'", "'++'", "'--'", "'+'", "'-'", "'*'", "'/'", 
		"'&'", "'|'", "'^'", "'%'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "CTX", "EXT", "FN", "STD", "IntegerLiteral", "FloatingPointLiteral", 
		"BooleanLiteral", "CharacterLiteral", "StringLiteral", "NullLiteral", 
		"LPAREN", "RPAREN", "LBRACE", "RBRACE", "LBRACK", "RBRACK", "SEMI", "DOT", 
		"COMMA", "ASSIGN", "GT", "LT", "BANG", "TILDE", "QUESTION", "COLON", "COLONCOLON", 
		"EQUAL", "LE", "GE", "NOTEQUAL", "AND", "OR", "INC", "DEC", "ADD", "SUB", 
		"MUL", "DIV", "BITAND", "BITOR", "CARET", "MOD", "Identifier", "WS", "COMMENT", 
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
			setState(41);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CTX) | (1L << EXT) | (1L << FN) | (1L << STD) | (1L << Identifier))) != 0)) {
				{
				{
				setState(36);
				statement();
				setState(37);
				match(SEMI);
				}
				}
				setState(43);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(44);
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
			setState(50);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				_localctx = new FunctionStatementContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(46);
				function();
				}
				break;
			case 2:
				_localctx = new InvocationStatementContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(47);
				invocation();
				}
				break;
			case 3:
				_localctx = new ExternalLayoutStatementContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(48);
				externalLayout();
				}
				break;
			case 4:
				_localctx = new ContextLayoutStatementContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(49);
				contextLayout();
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
		enterRule(_localctx, 4, RULE_externalLayout);
		try {
			setState(59);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				_localctx = new SingleExternalLayoutDeclarationContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(52);
				match(EXT);
				setState(53);
				reference();
				}
				break;
			case 2:
				_localctx = new MultiExternalLayoutDeclarationContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(54);
				match(EXT);
				setState(55);
				match(LBRACE);
				setState(56);
				externalEntries();
				setState(57);
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
		enterRule(_localctx, 6, RULE_externalEntries);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(64); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(61);
				reference();
				setState(62);
				match(SEMI);
				}
				}
				setState(66); 
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
		enterRule(_localctx, 8, RULE_externalEntryReference);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(68);
			match(EXT);
			setState(69);
			match(COLONCOLON);
			setState(70);
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
		enterRule(_localctx, 10, RULE_contextLayout);
		try {
			setState(79);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				_localctx = new SingleContextLayoutDeclarationContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(72);
				match(CTX);
				setState(73);
				match(Identifier);
				}
				break;
			case 2:
				_localctx = new MultiContextLayoutDeclarationContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(74);
				match(CTX);
				setState(75);
				match(LBRACE);
				setState(76);
				contextEntries();
				setState(77);
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
		enterRule(_localctx, 12, RULE_contextEntries);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(83); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(81);
				match(Identifier);
				setState(82);
				match(SEMI);
				}
				}
				setState(85); 
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
		enterRule(_localctx, 14, RULE_contextEntryReference);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(87);
			match(CTX);
			setState(88);
			match(COLONCOLON);
			setState(89);
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
		enterRule(_localctx, 16, RULE_function);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(91);
			match(FN);
			setState(92);
			match(Identifier);
			setState(93);
			match(LPAREN);
			setState(94);
			match(RPAREN);
			setState(95);
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
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public TerminalNode RBRACE() { return getToken(ContinuityParser.RBRACE, 0); }
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
		enterRule(_localctx, 18, RULE_block);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(97);
			match(LBRACE);
			setState(98);
			statements();
			setState(99);
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

	public static class StatementsContext extends ParserRuleContext {
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
		public StatementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statements; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ContinuityParserListener ) ((ContinuityParserListener)listener).enterStatements(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ContinuityParserListener ) ((ContinuityParserListener)listener).exitStatements(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ContinuityParserVisitor ) return ((ContinuityParserVisitor<? extends T>)visitor).visitStatements(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementsContext statements() throws RecognitionException {
		StatementsContext _localctx = new StatementsContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_statements);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(104); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(101);
				statement();
				setState(102);
				match(SEMI);
				}
				}
				setState(106); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CTX) | (1L << EXT) | (1L << FN) | (1L << STD) | (1L << Identifier))) != 0) );
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
	public static class ExternalReferenceInvocationContext extends InvocationContext {
		public ExternalEntryReferenceContext externalEntryReference() {
			return getRuleContext(ExternalEntryReferenceContext.class,0);
		}
		public TerminalNode DOT() { return getToken(ContinuityParser.DOT, 0); }
		public ReferenceTargetContext referenceTarget() {
			return getRuleContext(ReferenceTargetContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(ContinuityParser.LPAREN, 0); }
		public ParamsContext params() {
			return getRuleContext(ParamsContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(ContinuityParser.RPAREN, 0); }
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
	public static class ExternalDirectInvocationContext extends InvocationContext {
		public ReferenceContext reference() {
			return getRuleContext(ReferenceContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(ContinuityParser.LPAREN, 0); }
		public ParamsContext params() {
			return getRuleContext(ParamsContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(ContinuityParser.RPAREN, 0); }
		public ExternalDirectInvocationContext(InvocationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ContinuityParserListener ) ((ContinuityParserListener)listener).enterExternalDirectInvocation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ContinuityParserListener ) ((ContinuityParserListener)listener).exitExternalDirectInvocation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ContinuityParserVisitor ) return ((ContinuityParserVisitor<? extends T>)visitor).visitExternalDirectInvocation(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StdInvocationContext extends InvocationContext {
		public TerminalNode STD() { return getToken(ContinuityParser.STD, 0); }
		public TerminalNode COLONCOLON() { return getToken(ContinuityParser.COLONCOLON, 0); }
		public ReferenceContext reference() {
			return getRuleContext(ReferenceContext.class,0);
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
		public TerminalNode COLONCOLON() { return getToken(ContinuityParser.COLONCOLON, 0); }
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
		enterRule(_localctx, 22, RULE_invocation);
		try {
			setState(133);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STD:
				_localctx = new StdInvocationContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(108);
				match(STD);
				setState(109);
				match(COLONCOLON);
				setState(110);
				reference();
				setState(111);
				match(LPAREN);
				setState(112);
				params();
				setState(113);
				match(RPAREN);
				}
				break;
			case FN:
				_localctx = new FunctionInvocationContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(115);
				match(FN);
				setState(116);
				match(COLONCOLON);
				setState(117);
				referenceTarget();
				setState(118);
				match(LPAREN);
				setState(119);
				match(RPAREN);
				}
				break;
			case Identifier:
				_localctx = new ExternalDirectInvocationContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(121);
				reference();
				setState(122);
				match(LPAREN);
				setState(123);
				params();
				setState(124);
				match(RPAREN);
				}
				break;
			case EXT:
				_localctx = new ExternalReferenceInvocationContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(126);
				externalEntryReference();
				setState(127);
				match(DOT);
				setState(128);
				referenceTarget();
				setState(129);
				match(LPAREN);
				setState(130);
				params();
				setState(131);
				match(RPAREN);
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
		enterRule(_localctx, 24, RULE_params);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(143);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CTX) | (1L << EXT) | (1L << FN) | (1L << STD) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << NullLiteral) | (1L << Identifier))) != 0)) {
				{
				setState(135);
				param();
				setState(140);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(136);
					match(COMMA);
					setState(137);
					param();
					}
					}
					setState(142);
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

	public final ParamContext param() throws RecognitionException {
		ParamContext _localctx = new ParamContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_param);
		try {
			setState(148);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IntegerLiteral:
			case FloatingPointLiteral:
			case BooleanLiteral:
			case CharacterLiteral:
			case StringLiteral:
			case NullLiteral:
				_localctx = new LiteralParamContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(145);
				literal();
				}
				break;
			case CTX:
				_localctx = new ContextEntryReferenceParamContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(146);
				contextEntryReference();
				}
				break;
			case EXT:
			case FN:
			case STD:
			case Identifier:
				_localctx = new InvocationParamContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(147);
				invocation();
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
		enterRule(_localctx, 28, RULE_reference);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(151);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				{
				setState(150);
				referenceChain();
				}
				break;
			}
			setState(153);
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
		enterRule(_localctx, 30, RULE_referenceTarget);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(155);
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
		enterRule(_localctx, 32, RULE_referenceChain);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(159); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(157);
					match(Identifier);
					setState(158);
					match(DOT);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(161); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
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
		enterRule(_localctx, 34, RULE_literal);
		try {
			setState(169);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IntegerLiteral:
				_localctx = new IntegerLiteralContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(163);
				match(IntegerLiteral);
				}
				break;
			case FloatingPointLiteral:
				_localctx = new FloatingPointLiteralContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(164);
				match(FloatingPointLiteral);
				}
				break;
			case BooleanLiteral:
				_localctx = new BooleanLiteralContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(165);
				match(BooleanLiteral);
				}
				break;
			case CharacterLiteral:
				_localctx = new CharacterLiteralContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(166);
				match(CharacterLiteral);
				}
				break;
			case StringLiteral:
				_localctx = new StringLiteralContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(167);
				match(StringLiteral);
				}
				break;
			case NullLiteral:
				_localctx = new NullLiteralContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(168);
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\61\u00ae\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\3\2\3\2\3\2\7\2*\n\2\f\2\16\2-\13\2\3\2\3\2\3\3\3\3\3\3\3\3"+
		"\5\3\65\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4>\n\4\3\5\3\5\3\5\6\5C\n\5"+
		"\r\5\16\5D\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7R\n\7\3\b\3"+
		"\b\6\bV\n\b\r\b\16\bW\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13"+
		"\3\13\3\13\3\f\3\f\3\f\6\fk\n\f\r\f\16\fl\3\r\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\5\r\u0088\n\r\3\16\3\16\3\16\7\16\u008d\n\16\f\16\16\16\u0090\13\16"+
		"\5\16\u0092\n\16\3\17\3\17\3\17\5\17\u0097\n\17\3\20\5\20\u009a\n\20\3"+
		"\20\3\20\3\21\3\21\3\22\3\22\6\22\u00a2\n\22\r\22\16\22\u00a3\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\5\23\u00ac\n\23\3\23\2\2\24\2\4\6\b\n\f\16\20\22"+
		"\24\26\30\32\34\36 \"$\2\2\2\u00b2\2+\3\2\2\2\4\64\3\2\2\2\6=\3\2\2\2"+
		"\bB\3\2\2\2\nF\3\2\2\2\fQ\3\2\2\2\16U\3\2\2\2\20Y\3\2\2\2\22]\3\2\2\2"+
		"\24c\3\2\2\2\26j\3\2\2\2\30\u0087\3\2\2\2\32\u0091\3\2\2\2\34\u0096\3"+
		"\2\2\2\36\u0099\3\2\2\2 \u009d\3\2\2\2\"\u00a1\3\2\2\2$\u00ab\3\2\2\2"+
		"&\'\5\4\3\2\'(\7\23\2\2(*\3\2\2\2)&\3\2\2\2*-\3\2\2\2+)\3\2\2\2+,\3\2"+
		"\2\2,.\3\2\2\2-+\3\2\2\2./\7\2\2\3/\3\3\2\2\2\60\65\5\22\n\2\61\65\5\30"+
		"\r\2\62\65\5\6\4\2\63\65\5\f\7\2\64\60\3\2\2\2\64\61\3\2\2\2\64\62\3\2"+
		"\2\2\64\63\3\2\2\2\65\5\3\2\2\2\66\67\7\4\2\2\67>\5\36\20\289\7\4\2\2"+
		"9:\7\17\2\2:;\5\b\5\2;<\7\20\2\2<>\3\2\2\2=\66\3\2\2\2=8\3\2\2\2>\7\3"+
		"\2\2\2?@\5\36\20\2@A\7\23\2\2AC\3\2\2\2B?\3\2\2\2CD\3\2\2\2DB\3\2\2\2"+
		"DE\3\2\2\2E\t\3\2\2\2FG\7\4\2\2GH\7\35\2\2HI\7.\2\2I\13\3\2\2\2JK\7\3"+
		"\2\2KR\7.\2\2LM\7\3\2\2MN\7\17\2\2NO\5\16\b\2OP\7\20\2\2PR\3\2\2\2QJ\3"+
		"\2\2\2QL\3\2\2\2R\r\3\2\2\2ST\7.\2\2TV\7\23\2\2US\3\2\2\2VW\3\2\2\2WU"+
		"\3\2\2\2WX\3\2\2\2X\17\3\2\2\2YZ\7\3\2\2Z[\7\35\2\2[\\\7.\2\2\\\21\3\2"+
		"\2\2]^\7\5\2\2^_\7.\2\2_`\7\r\2\2`a\7\16\2\2ab\5\24\13\2b\23\3\2\2\2c"+
		"d\7\17\2\2de\5\26\f\2ef\7\20\2\2f\25\3\2\2\2gh\5\4\3\2hi\7\23\2\2ik\3"+
		"\2\2\2jg\3\2\2\2kl\3\2\2\2lj\3\2\2\2lm\3\2\2\2m\27\3\2\2\2no\7\6\2\2o"+
		"p\7\35\2\2pq\5\36\20\2qr\7\r\2\2rs\5\32\16\2st\7\16\2\2t\u0088\3\2\2\2"+
		"uv\7\5\2\2vw\7\35\2\2wx\5 \21\2xy\7\r\2\2yz\7\16\2\2z\u0088\3\2\2\2{|"+
		"\5\36\20\2|}\7\r\2\2}~\5\32\16\2~\177\7\16\2\2\177\u0088\3\2\2\2\u0080"+
		"\u0081\5\n\6\2\u0081\u0082\7\24\2\2\u0082\u0083\5 \21\2\u0083\u0084\7"+
		"\r\2\2\u0084\u0085\5\32\16\2\u0085\u0086\7\16\2\2\u0086\u0088\3\2\2\2"+
		"\u0087n\3\2\2\2\u0087u\3\2\2\2\u0087{\3\2\2\2\u0087\u0080\3\2\2\2\u0088"+
		"\31\3\2\2\2\u0089\u008e\5\34\17\2\u008a\u008b\7\25\2\2\u008b\u008d\5\34"+
		"\17\2\u008c\u008a\3\2\2\2\u008d\u0090\3\2\2\2\u008e\u008c\3\2\2\2\u008e"+
		"\u008f\3\2\2\2\u008f\u0092\3\2\2\2\u0090\u008e\3\2\2\2\u0091\u0089\3\2"+
		"\2\2\u0091\u0092\3\2\2\2\u0092\33\3\2\2\2\u0093\u0097\5$\23\2\u0094\u0097"+
		"\5\20\t\2\u0095\u0097\5\30\r\2\u0096\u0093\3\2\2\2\u0096\u0094\3\2\2\2"+
		"\u0096\u0095\3\2\2\2\u0097\35\3\2\2\2\u0098\u009a\5\"\22\2\u0099\u0098"+
		"\3\2\2\2\u0099\u009a\3\2\2\2\u009a\u009b\3\2\2\2\u009b\u009c\5 \21\2\u009c"+
		"\37\3\2\2\2\u009d\u009e\7.\2\2\u009e!\3\2\2\2\u009f\u00a0\7.\2\2\u00a0"+
		"\u00a2\7\24\2\2\u00a1\u009f\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3\u00a1\3"+
		"\2\2\2\u00a3\u00a4\3\2\2\2\u00a4#\3\2\2\2\u00a5\u00ac\7\7\2\2\u00a6\u00ac"+
		"\7\b\2\2\u00a7\u00ac\7\t\2\2\u00a8\u00ac\7\n\2\2\u00a9\u00ac\7\13\2\2"+
		"\u00aa\u00ac\7\f\2\2\u00ab\u00a5\3\2\2\2\u00ab\u00a6\3\2\2\2\u00ab\u00a7"+
		"\3\2\2\2\u00ab\u00a8\3\2\2\2\u00ab\u00a9\3\2\2\2\u00ab\u00aa\3\2\2\2\u00ac"+
		"%\3\2\2\2\20+\64=DQWl\u0087\u008e\u0091\u0096\u0099\u00a3\u00ab";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}