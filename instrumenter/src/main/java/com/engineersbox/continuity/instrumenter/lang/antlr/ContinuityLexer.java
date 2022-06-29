// Generated from ContinuityLexer.g4 by ANTLR 4.7.1

package com.engineersbox.continuity.instrumenter.lang.antlr;

import com.engineersbox.continuity.instrumenter.lang.lexer.LexerBase;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ContinuityLexer extends LexerBase {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		CTX=1, EXT=2, FN=3, STD=4, IntegerLiteral=5, FloatingPointLiteral=6, BooleanLiteral=7, 
		CharacterLiteral=8, StringLiteral=9, NullLiteral=10, LPAREN=11, RPAREN=12, 
		LBRACE=13, RBRACE=14, LBRACK=15, RBRACK=16, SEMI=17, DOT=18, DOLLAR=19, 
		COMMA=20, ARROW=21, ASSIGN=22, GT=23, LT=24, BANG=25, TILDE=26, QUESTION=27, 
		COLON=28, COLONCOLON=29, EQUAL=30, LE=31, GE=32, NOTEQUAL=33, AND=34, 
		OR=35, INC=36, DEC=37, ADD=38, SUB=39, MUL=40, DIV=41, BITAND=42, BITOR=43, 
		CARET=44, MOD=45, Identifier=46, WS=47, COMMENT=48, LINE_COMMENT=49;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"CTX", "EXT", "FN", "STD", "IntegerLiteral", "DecimalIntegerLiteral", 
		"HexIntegerLiteral", "OctalIntegerLiteral", "BinaryIntegerLiteral", "IntegerTypeSuffix", 
		"DecimalNumeral", "Digits", "Digit", "NonZeroDigit", "DigitsAndUnderscores", 
		"DigitOrUnderscore", "Underscores", "HexNumeral", "HexDigits", "HexDigit", 
		"HexDigitsAndUnderscores", "HexDigitOrUnderscore", "OctalNumeral", "OctalDigits", 
		"OctalDigit", "OctalDigitsAndUnderscores", "OctalDigitOrUnderscore", "BinaryNumeral", 
		"BinaryDigits", "BinaryDigit", "BinaryDigitsAndUnderscores", "BinaryDigitOrUnderscore", 
		"FloatingPointLiteral", "DecimalFloatingPointLiteral", "ExponentPart", 
		"ExponentIndicator", "SignedInteger", "Sign", "FloatTypeSuffix", "HexadecimalFloatingPointLiteral", 
		"HexSignificand", "BinaryExponent", "BinaryExponentIndicator", "BooleanLiteral", 
		"CharacterLiteral", "SingleCharacter", "StringLiteral", "StringCharacters", 
		"StringCharacter", "EscapeSequence", "OctalEscape", "ZeroToThree", "UnicodeEscape", 
		"NullLiteral", "LPAREN", "RPAREN", "LBRACE", "RBRACE", "LBRACK", "RBRACK", 
		"SEMI", "DOT", "DOLLAR", "COMMA", "ARROW", "ASSIGN", "GT", "LT", "BANG", 
		"TILDE", "QUESTION", "COLON", "COLONCOLON", "EQUAL", "LE", "GE", "NOTEQUAL", 
		"AND", "OR", "INC", "DEC", "ADD", "SUB", "MUL", "DIV", "BITAND", "BITOR", 
		"CARET", "MOD", "Identifier", "Letter", "LetterOrDigitNoDollar", "LetterOrDigit", 
		"WS", "COMMENT", "LINE_COMMENT"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'ctx'", "'ext'", "'fn'", "'std'", null, null, null, null, null, 
		"'null'", "'('", "')'", "'{'", "'}'", "'['", "']'", "';'", "'.'", "'$'", 
		"','", "'->'", "'='", "'>'", "'<'", "'!'", "'~'", "'?'", "':'", "'::'", 
		"'=='", "'<='", "'>='", "'!='", "'&&'", "'||'", "'++'", "'--'", "'+'", 
		"'-'", "'*'", "'/'", "'&'", "'|'", "'^'", "'%'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "CTX", "EXT", "FN", "STD", "IntegerLiteral", "FloatingPointLiteral", 
		"BooleanLiteral", "CharacterLiteral", "StringLiteral", "NullLiteral", 
		"LPAREN", "RPAREN", "LBRACE", "RBRACE", "LBRACK", "RBRACK", "SEMI", "DOT", 
		"DOLLAR", "COMMA", "ARROW", "ASSIGN", "GT", "LT", "BANG", "TILDE", "QUESTION", 
		"COLON", "COLONCOLON", "EQUAL", "LE", "GE", "NOTEQUAL", "AND", "OR", "INC", 
		"DEC", "ADD", "SUB", "MUL", "DIV", "BITAND", "BITOR", "CARET", "MOD", 
		"Identifier", "WS", "COMMENT", "LINE_COMMENT"
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


	public ContinuityLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "ContinuityLexer.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 90:
			return Letter_sempred((RuleContext)_localctx, predIndex);
		case 91:
			return LetterOrDigitNoDollar_sempred((RuleContext)_localctx, predIndex);
		case 92:
			return LetterOrDigit_sempred((RuleContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean Letter_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return  checkSupportedSingletonCharacters() ;
		case 1:
			return  checkSupportedSurrogatePairCharacters() ;
		}
		return true;
	}
	private boolean LetterOrDigitNoDollar_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return  checkSupportedSingletonCharacters() ;
		case 3:
			return  checkSupportedSurrogatePairCharacters() ;
		}
		return true;
	}
	private boolean LetterOrDigit_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 4:
			return  checkSupportedSingletonCharacters() ;
		case 5:
			return  checkSupportedSurrogatePairCharacters() ;
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\63\u027a\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64"+
		"\t\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t"+
		"=\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4"+
		"I\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4R\tR\4S\tS\4T\t"+
		"T\4U\tU\4V\tV\4W\tW\4X\tX\4Y\tY\4Z\tZ\4[\t[\4\\\t\\\4]\t]\4^\t^\4_\t_"+
		"\4`\t`\4a\ta\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\5\3\5\3\5\3"+
		"\5\3\6\3\6\3\6\3\6\5\6\u00d7\n\6\3\7\3\7\5\7\u00db\n\7\3\b\3\b\5\b\u00df"+
		"\n\b\3\t\3\t\5\t\u00e3\n\t\3\n\3\n\5\n\u00e7\n\n\3\13\3\13\3\f\3\f\3\f"+
		"\5\f\u00ee\n\f\3\f\3\f\3\f\5\f\u00f3\n\f\5\f\u00f5\n\f\3\r\3\r\5\r\u00f9"+
		"\n\r\3\r\5\r\u00fc\n\r\3\16\3\16\5\16\u0100\n\16\3\17\3\17\3\20\6\20\u0105"+
		"\n\20\r\20\16\20\u0106\3\21\3\21\5\21\u010b\n\21\3\22\6\22\u010e\n\22"+
		"\r\22\16\22\u010f\3\23\3\23\3\23\3\23\3\24\3\24\5\24\u0118\n\24\3\24\5"+
		"\24\u011b\n\24\3\25\3\25\3\26\6\26\u0120\n\26\r\26\16\26\u0121\3\27\3"+
		"\27\5\27\u0126\n\27\3\30\3\30\5\30\u012a\n\30\3\30\3\30\3\31\3\31\5\31"+
		"\u0130\n\31\3\31\5\31\u0133\n\31\3\32\3\32\3\33\6\33\u0138\n\33\r\33\16"+
		"\33\u0139\3\34\3\34\5\34\u013e\n\34\3\35\3\35\3\35\3\35\3\36\3\36\5\36"+
		"\u0146\n\36\3\36\5\36\u0149\n\36\3\37\3\37\3 \6 \u014e\n \r \16 \u014f"+
		"\3!\3!\5!\u0154\n!\3\"\3\"\5\"\u0158\n\"\3#\3#\3#\5#\u015d\n#\3#\5#\u0160"+
		"\n#\3#\5#\u0163\n#\3#\3#\3#\5#\u0168\n#\3#\5#\u016b\n#\3#\3#\3#\5#\u0170"+
		"\n#\3#\3#\3#\5#\u0175\n#\3$\3$\3$\3%\3%\3&\5&\u017d\n&\3&\3&\3\'\3\'\3"+
		"(\3(\3)\3)\3)\5)\u0188\n)\3*\3*\5*\u018c\n*\3*\3*\3*\5*\u0191\n*\3*\3"+
		"*\5*\u0195\n*\3+\3+\3+\3,\3,\3-\3-\3-\3-\3-\3-\3-\3-\3-\5-\u01a5\n-\3"+
		".\3.\3.\3.\3.\3.\3.\3.\5.\u01af\n.\3/\3/\3\60\3\60\5\60\u01b5\n\60\3\60"+
		"\3\60\3\61\6\61\u01ba\n\61\r\61\16\61\u01bb\3\62\3\62\5\62\u01c0\n\62"+
		"\3\63\3\63\3\63\3\63\5\63\u01c6\n\63\3\64\3\64\3\64\3\64\3\64\3\64\3\64"+
		"\3\64\3\64\3\64\3\64\5\64\u01d3\n\64\3\65\3\65\3\66\3\66\6\66\u01d9\n"+
		"\66\r\66\16\66\u01da\3\66\3\66\3\66\3\66\3\66\3\67\3\67\3\67\3\67\3\67"+
		"\38\38\39\39\3:\3:\3;\3;\3<\3<\3=\3=\3>\3>\3?\3?\3@\3@\3A\3A\3B\3B\3B"+
		"\3C\3C\3D\3D\3E\3E\3F\3F\3G\3G\3H\3H\3I\3I\3J\3J\3J\3K\3K\3K\3L\3L\3L"+
		"\3M\3M\3M\3N\3N\3N\3O\3O\3O\3P\3P\3P\3Q\3Q\3Q\3R\3R\3R\3S\3S\3T\3T\3U"+
		"\3U\3V\3V\3W\3W\3X\3X\3Y\3Y\3Z\3Z\3[\3[\7[\u0239\n[\f[\16[\u023c\13[\5"+
		"[\u023e\n[\3[\5[\u0241\n[\3\\\3\\\3\\\3\\\3\\\3\\\5\\\u0249\n\\\3]\3]"+
		"\3]\3]\3]\3]\5]\u0251\n]\3^\3^\3^\3^\3^\3^\5^\u0259\n^\3_\6_\u025c\n_"+
		"\r_\16_\u025d\3_\3_\3`\3`\3`\3`\7`\u0266\n`\f`\16`\u0269\13`\3`\3`\3`"+
		"\3`\3`\3a\3a\3a\3a\7a\u0274\na\fa\16a\u0277\13a\3a\3a\3\u0267\2b\3\3\5"+
		"\4\7\5\t\6\13\7\r\2\17\2\21\2\23\2\25\2\27\2\31\2\33\2\35\2\37\2!\2#\2"+
		"%\2\'\2)\2+\2-\2/\2\61\2\63\2\65\2\67\29\2;\2=\2?\2A\2C\bE\2G\2I\2K\2"+
		"M\2O\2Q\2S\2U\2W\2Y\t[\n]\2_\13a\2c\2e\2g\2i\2k\2m\fo\rq\16s\17u\20w\21"+
		"y\22{\23}\24\177\25\u0081\26\u0083\27\u0085\30\u0087\31\u0089\32\u008b"+
		"\33\u008d\34\u008f\35\u0091\36\u0093\37\u0095 \u0097!\u0099\"\u009b#\u009d"+
		"$\u009f%\u00a1&\u00a3\'\u00a5(\u00a7)\u00a9*\u00ab+\u00ad,\u00af-\u00b1"+
		".\u00b3/\u00b5\60\u00b7\2\u00b9\2\u00bb\2\u00bd\61\u00bf\62\u00c1\63\3"+
		"\2\31\4\2NNnn\3\2\63;\4\2ZZzz\5\2\62;CHch\3\2\629\4\2DDdd\3\2\62\63\4"+
		"\2GGgg\4\2--//\6\2FFHHffhh\4\2RRrr\6\2\f\f\17\17))^^\6\2\f\f\17\17$$^"+
		"^\n\2$$))^^ddhhppttvv\3\2\62\65\6\2&&C\\aac|\4\2\2\u0081\ud802\udc01\3"+
		"\2\ud802\udc01\3\2\udc02\ue001\6\2\62;C\\aac|\7\2&&\62;C\\aac|\5\2\13"+
		"\f\16\17\"\"\4\2\f\f\17\17\2\u028c\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2"+
		"\2\t\3\2\2\2\2\13\3\2\2\2\2C\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2_\3\2\2\2"+
		"\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\2u\3\2\2\2\2w\3\2\2\2\2y"+
		"\3\2\2\2\2{\3\2\2\2\2}\3\2\2\2\2\177\3\2\2\2\2\u0081\3\2\2\2\2\u0083\3"+
		"\2\2\2\2\u0085\3\2\2\2\2\u0087\3\2\2\2\2\u0089\3\2\2\2\2\u008b\3\2\2\2"+
		"\2\u008d\3\2\2\2\2\u008f\3\2\2\2\2\u0091\3\2\2\2\2\u0093\3\2\2\2\2\u0095"+
		"\3\2\2\2\2\u0097\3\2\2\2\2\u0099\3\2\2\2\2\u009b\3\2\2\2\2\u009d\3\2\2"+
		"\2\2\u009f\3\2\2\2\2\u00a1\3\2\2\2\2\u00a3\3\2\2\2\2\u00a5\3\2\2\2\2\u00a7"+
		"\3\2\2\2\2\u00a9\3\2\2\2\2\u00ab\3\2\2\2\2\u00ad\3\2\2\2\2\u00af\3\2\2"+
		"\2\2\u00b1\3\2\2\2\2\u00b3\3\2\2\2\2\u00b5\3\2\2\2\2\u00bd\3\2\2\2\2\u00bf"+
		"\3\2\2\2\2\u00c1\3\2\2\2\3\u00c3\3\2\2\2\5\u00c7\3\2\2\2\7\u00cb\3\2\2"+
		"\2\t\u00ce\3\2\2\2\13\u00d6\3\2\2\2\r\u00d8\3\2\2\2\17\u00dc\3\2\2\2\21"+
		"\u00e0\3\2\2\2\23\u00e4\3\2\2\2\25\u00e8\3\2\2\2\27\u00f4\3\2\2\2\31\u00f6"+
		"\3\2\2\2\33\u00ff\3\2\2\2\35\u0101\3\2\2\2\37\u0104\3\2\2\2!\u010a\3\2"+
		"\2\2#\u010d\3\2\2\2%\u0111\3\2\2\2\'\u0115\3\2\2\2)\u011c\3\2\2\2+\u011f"+
		"\3\2\2\2-\u0125\3\2\2\2/\u0127\3\2\2\2\61\u012d\3\2\2\2\63\u0134\3\2\2"+
		"\2\65\u0137\3\2\2\2\67\u013d\3\2\2\29\u013f\3\2\2\2;\u0143\3\2\2\2=\u014a"+
		"\3\2\2\2?\u014d\3\2\2\2A\u0153\3\2\2\2C\u0157\3\2\2\2E\u0174\3\2\2\2G"+
		"\u0176\3\2\2\2I\u0179\3\2\2\2K\u017c\3\2\2\2M\u0180\3\2\2\2O\u0182\3\2"+
		"\2\2Q\u0184\3\2\2\2S\u0194\3\2\2\2U\u0196\3\2\2\2W\u0199\3\2\2\2Y\u01a4"+
		"\3\2\2\2[\u01ae\3\2\2\2]\u01b0\3\2\2\2_\u01b2\3\2\2\2a\u01b9\3\2\2\2c"+
		"\u01bf\3\2\2\2e\u01c5\3\2\2\2g\u01d2\3\2\2\2i\u01d4\3\2\2\2k\u01d6\3\2"+
		"\2\2m\u01e1\3\2\2\2o\u01e6\3\2\2\2q\u01e8\3\2\2\2s\u01ea\3\2\2\2u\u01ec"+
		"\3\2\2\2w\u01ee\3\2\2\2y\u01f0\3\2\2\2{\u01f2\3\2\2\2}\u01f4\3\2\2\2\177"+
		"\u01f6\3\2\2\2\u0081\u01f8\3\2\2\2\u0083\u01fa\3\2\2\2\u0085\u01fd\3\2"+
		"\2\2\u0087\u01ff\3\2\2\2\u0089\u0201\3\2\2\2\u008b\u0203\3\2\2\2\u008d"+
		"\u0205\3\2\2\2\u008f\u0207\3\2\2\2\u0091\u0209\3\2\2\2\u0093\u020b\3\2"+
		"\2\2\u0095\u020e\3\2\2\2\u0097\u0211\3\2\2\2\u0099\u0214\3\2\2\2\u009b"+
		"\u0217\3\2\2\2\u009d\u021a\3\2\2\2\u009f\u021d\3\2\2\2\u00a1\u0220\3\2"+
		"\2\2\u00a3\u0223\3\2\2\2\u00a5\u0226\3\2\2\2\u00a7\u0228\3\2\2\2\u00a9"+
		"\u022a\3\2\2\2\u00ab\u022c\3\2\2\2\u00ad\u022e\3\2\2\2\u00af\u0230\3\2"+
		"\2\2\u00b1\u0232\3\2\2\2\u00b3\u0234\3\2\2\2\u00b5\u0236\3\2\2\2\u00b7"+
		"\u0248\3\2\2\2\u00b9\u0250\3\2\2\2\u00bb\u0258\3\2\2\2\u00bd\u025b\3\2"+
		"\2\2\u00bf\u0261\3\2\2\2\u00c1\u026f\3\2\2\2\u00c3\u00c4\7e\2\2\u00c4"+
		"\u00c5\7v\2\2\u00c5\u00c6\7z\2\2\u00c6\4\3\2\2\2\u00c7\u00c8\7g\2\2\u00c8"+
		"\u00c9\7z\2\2\u00c9\u00ca\7v\2\2\u00ca\6\3\2\2\2\u00cb\u00cc\7h\2\2\u00cc"+
		"\u00cd\7p\2\2\u00cd\b\3\2\2\2\u00ce\u00cf\7u\2\2\u00cf\u00d0\7v\2\2\u00d0"+
		"\u00d1\7f\2\2\u00d1\n\3\2\2\2\u00d2\u00d7\5\r\7\2\u00d3\u00d7\5\17\b\2"+
		"\u00d4\u00d7\5\21\t\2\u00d5\u00d7\5\23\n\2\u00d6\u00d2\3\2\2\2\u00d6\u00d3"+
		"\3\2\2\2\u00d6\u00d4\3\2\2\2\u00d6\u00d5\3\2\2\2\u00d7\f\3\2\2\2\u00d8"+
		"\u00da\5\27\f\2\u00d9\u00db\5\25\13\2\u00da\u00d9\3\2\2\2\u00da\u00db"+
		"\3\2\2\2\u00db\16\3\2\2\2\u00dc\u00de\5%\23\2\u00dd\u00df\5\25\13\2\u00de"+
		"\u00dd\3\2\2\2\u00de\u00df\3\2\2\2\u00df\20\3\2\2\2\u00e0\u00e2\5/\30"+
		"\2\u00e1\u00e3\5\25\13\2\u00e2\u00e1\3\2\2\2\u00e2\u00e3\3\2\2\2\u00e3"+
		"\22\3\2\2\2\u00e4\u00e6\59\35\2\u00e5\u00e7\5\25\13\2\u00e6\u00e5\3\2"+
		"\2\2\u00e6\u00e7\3\2\2\2\u00e7\24\3\2\2\2\u00e8\u00e9\t\2\2\2\u00e9\26"+
		"\3\2\2\2\u00ea\u00f5\7\62\2\2\u00eb\u00f2\5\35\17\2\u00ec\u00ee\5\31\r"+
		"\2\u00ed\u00ec\3\2\2\2\u00ed\u00ee\3\2\2\2\u00ee\u00f3\3\2\2\2\u00ef\u00f0"+
		"\5#\22\2\u00f0\u00f1\5\31\r\2\u00f1\u00f3\3\2\2\2\u00f2\u00ed\3\2\2\2"+
		"\u00f2\u00ef\3\2\2\2\u00f3\u00f5\3\2\2\2\u00f4\u00ea\3\2\2\2\u00f4\u00eb"+
		"\3\2\2\2\u00f5\30\3\2\2\2\u00f6\u00fb\5\33\16\2\u00f7\u00f9\5\37\20\2"+
		"\u00f8\u00f7\3\2\2\2\u00f8\u00f9\3\2\2\2\u00f9\u00fa\3\2\2\2\u00fa\u00fc"+
		"\5\33\16\2\u00fb\u00f8\3\2\2\2\u00fb\u00fc\3\2\2\2\u00fc\32\3\2\2\2\u00fd"+
		"\u0100\7\62\2\2\u00fe\u0100\5\35\17\2\u00ff\u00fd\3\2\2\2\u00ff\u00fe"+
		"\3\2\2\2\u0100\34\3\2\2\2\u0101\u0102\t\3\2\2\u0102\36\3\2\2\2\u0103\u0105"+
		"\5!\21\2\u0104\u0103\3\2\2\2\u0105\u0106\3\2\2\2\u0106\u0104\3\2\2\2\u0106"+
		"\u0107\3\2\2\2\u0107 \3\2\2\2\u0108\u010b\5\33\16\2\u0109\u010b\7a\2\2"+
		"\u010a\u0108\3\2\2\2\u010a\u0109\3\2\2\2\u010b\"\3\2\2\2\u010c\u010e\7"+
		"a\2\2\u010d\u010c\3\2\2\2\u010e\u010f\3\2\2\2\u010f\u010d\3\2\2\2\u010f"+
		"\u0110\3\2\2\2\u0110$\3\2\2\2\u0111\u0112\7\62\2\2\u0112\u0113\t\4\2\2"+
		"\u0113\u0114\5\'\24\2\u0114&\3\2\2\2\u0115\u011a\5)\25\2\u0116\u0118\5"+
		"+\26\2\u0117\u0116\3\2\2\2\u0117\u0118\3\2\2\2\u0118\u0119\3\2\2\2\u0119"+
		"\u011b\5)\25\2\u011a\u0117\3\2\2\2\u011a\u011b\3\2\2\2\u011b(\3\2\2\2"+
		"\u011c\u011d\t\5\2\2\u011d*\3\2\2\2\u011e\u0120\5-\27\2\u011f\u011e\3"+
		"\2\2\2\u0120\u0121\3\2\2\2\u0121\u011f\3\2\2\2\u0121\u0122\3\2\2\2\u0122"+
		",\3\2\2\2\u0123\u0126\5)\25\2\u0124\u0126\7a\2\2\u0125\u0123\3\2\2\2\u0125"+
		"\u0124\3\2\2\2\u0126.\3\2\2\2\u0127\u0129\7\62\2\2\u0128\u012a\5#\22\2"+
		"\u0129\u0128\3\2\2\2\u0129\u012a\3\2\2\2\u012a\u012b\3\2\2\2\u012b\u012c"+
		"\5\61\31\2\u012c\60\3\2\2\2\u012d\u0132\5\63\32\2\u012e\u0130\5\65\33"+
		"\2\u012f\u012e\3\2\2\2\u012f\u0130\3\2\2\2\u0130\u0131\3\2\2\2\u0131\u0133"+
		"\5\63\32\2\u0132\u012f\3\2\2\2\u0132\u0133\3\2\2\2\u0133\62\3\2\2\2\u0134"+
		"\u0135\t\6\2\2\u0135\64\3\2\2\2\u0136\u0138\5\67\34\2\u0137\u0136\3\2"+
		"\2\2\u0138\u0139\3\2\2\2\u0139\u0137\3\2\2\2\u0139\u013a\3\2\2\2\u013a"+
		"\66\3\2\2\2\u013b\u013e\5\63\32\2\u013c\u013e\7a\2\2\u013d\u013b\3\2\2"+
		"\2\u013d\u013c\3\2\2\2\u013e8\3\2\2\2\u013f\u0140\7\62\2\2\u0140\u0141"+
		"\t\7\2\2\u0141\u0142\5;\36\2\u0142:\3\2\2\2\u0143\u0148\5=\37\2\u0144"+
		"\u0146\5? \2\u0145\u0144\3\2\2\2\u0145\u0146\3\2\2\2\u0146\u0147\3\2\2"+
		"\2\u0147\u0149\5=\37\2\u0148\u0145\3\2\2\2\u0148\u0149\3\2\2\2\u0149<"+
		"\3\2\2\2\u014a\u014b\t\b\2\2\u014b>\3\2\2\2\u014c\u014e\5A!\2\u014d\u014c"+
		"\3\2\2\2\u014e\u014f\3\2\2\2\u014f\u014d\3\2\2\2\u014f\u0150\3\2\2\2\u0150"+
		"@\3\2\2\2\u0151\u0154\5=\37\2\u0152\u0154\7a\2\2\u0153\u0151\3\2\2\2\u0153"+
		"\u0152\3\2\2\2\u0154B\3\2\2\2\u0155\u0158\5E#\2\u0156\u0158\5Q)\2\u0157"+
		"\u0155\3\2\2\2\u0157\u0156\3\2\2\2\u0158D\3\2\2\2\u0159\u015a\5\31\r\2"+
		"\u015a\u015c\7\60\2\2\u015b\u015d\5\31\r\2\u015c\u015b\3\2\2\2\u015c\u015d"+
		"\3\2\2\2\u015d\u015f\3\2\2\2\u015e\u0160\5G$\2\u015f\u015e\3\2\2\2\u015f"+
		"\u0160\3\2\2\2\u0160\u0162\3\2\2\2\u0161\u0163\5O(\2\u0162\u0161\3\2\2"+
		"\2\u0162\u0163\3\2\2\2\u0163\u0175\3\2\2\2\u0164\u0165\7\60\2\2\u0165"+
		"\u0167\5\31\r\2\u0166\u0168\5G$\2\u0167\u0166\3\2\2\2\u0167\u0168\3\2"+
		"\2\2\u0168\u016a\3\2\2\2\u0169\u016b\5O(\2\u016a\u0169\3\2\2\2\u016a\u016b"+
		"\3\2\2\2\u016b\u0175\3\2\2\2\u016c\u016d\5\31\r\2\u016d\u016f\5G$\2\u016e"+
		"\u0170\5O(\2\u016f\u016e\3\2\2\2\u016f\u0170\3\2\2\2\u0170\u0175\3\2\2"+
		"\2\u0171\u0172\5\31\r\2\u0172\u0173\5O(\2\u0173\u0175\3\2\2\2\u0174\u0159"+
		"\3\2\2\2\u0174\u0164\3\2\2\2\u0174\u016c\3\2\2\2\u0174\u0171\3\2\2\2\u0175"+
		"F\3\2\2\2\u0176\u0177\5I%\2\u0177\u0178\5K&\2\u0178H\3\2\2\2\u0179\u017a"+
		"\t\t\2\2\u017aJ\3\2\2\2\u017b\u017d\5M\'\2\u017c\u017b\3\2\2\2\u017c\u017d"+
		"\3\2\2\2\u017d\u017e\3\2\2\2\u017e\u017f\5\31\r\2\u017fL\3\2\2\2\u0180"+
		"\u0181\t\n\2\2\u0181N\3\2\2\2\u0182\u0183\t\13\2\2\u0183P\3\2\2\2\u0184"+
		"\u0185\5S*\2\u0185\u0187\5U+\2\u0186\u0188\5O(\2\u0187\u0186\3\2\2\2\u0187"+
		"\u0188\3\2\2\2\u0188R\3\2\2\2\u0189\u018b\5%\23\2\u018a\u018c\7\60\2\2"+
		"\u018b\u018a\3\2\2\2\u018b\u018c\3\2\2\2\u018c\u0195\3\2\2\2\u018d\u018e"+
		"\7\62\2\2\u018e\u0190\t\4\2\2\u018f\u0191\5\'\24\2\u0190\u018f\3\2\2\2"+
		"\u0190\u0191\3\2\2\2\u0191\u0192\3\2\2\2\u0192\u0193\7\60\2\2\u0193\u0195"+
		"\5\'\24\2\u0194\u0189\3\2\2\2\u0194\u018d\3\2\2\2\u0195T\3\2\2\2\u0196"+
		"\u0197\5W,\2\u0197\u0198\5K&\2\u0198V\3\2\2\2\u0199\u019a\t\f\2\2\u019a"+
		"X\3\2\2\2\u019b\u019c\7v\2\2\u019c\u019d\7t\2\2\u019d\u019e\7w\2\2\u019e"+
		"\u01a5\7g\2\2\u019f\u01a0\7h\2\2\u01a0\u01a1\7c\2\2\u01a1\u01a2\7n\2\2"+
		"\u01a2\u01a3\7u\2\2\u01a3\u01a5\7g\2\2\u01a4\u019b\3\2\2\2\u01a4\u019f"+
		"\3\2\2\2\u01a5Z\3\2\2\2\u01a6\u01a7\7)\2\2\u01a7\u01a8\5]/\2\u01a8\u01a9"+
		"\7)\2\2\u01a9\u01af\3\2\2\2\u01aa\u01ab\7)\2\2\u01ab\u01ac\5e\63\2\u01ac"+
		"\u01ad\7)\2\2\u01ad\u01af\3\2\2\2\u01ae\u01a6\3\2\2\2\u01ae\u01aa\3\2"+
		"\2\2\u01af\\\3\2\2\2\u01b0\u01b1\n\r\2\2\u01b1^\3\2\2\2\u01b2\u01b4\7"+
		"$\2\2\u01b3\u01b5\5a\61\2\u01b4\u01b3\3\2\2\2\u01b4\u01b5\3\2\2\2\u01b5"+
		"\u01b6\3\2\2\2\u01b6\u01b7\7$\2\2\u01b7`\3\2\2\2\u01b8\u01ba\5c\62\2\u01b9"+
		"\u01b8\3\2\2\2\u01ba\u01bb\3\2\2\2\u01bb\u01b9\3\2\2\2\u01bb\u01bc\3\2"+
		"\2\2\u01bcb\3\2\2\2\u01bd\u01c0\n\16\2\2\u01be\u01c0\5e\63\2\u01bf\u01bd"+
		"\3\2\2\2\u01bf\u01be\3\2\2\2\u01c0d\3\2\2\2\u01c1\u01c2\7^\2\2\u01c2\u01c6"+
		"\t\17\2\2\u01c3\u01c6\5g\64\2\u01c4\u01c6\5k\66\2\u01c5\u01c1\3\2\2\2"+
		"\u01c5\u01c3\3\2\2\2\u01c5\u01c4\3\2\2\2\u01c6f\3\2\2\2\u01c7\u01c8\7"+
		"^\2\2\u01c8\u01d3\5\63\32\2\u01c9\u01ca\7^\2\2\u01ca\u01cb\5\63\32\2\u01cb"+
		"\u01cc\5\63\32\2\u01cc\u01d3\3\2\2\2\u01cd\u01ce\7^\2\2\u01ce\u01cf\5"+
		"i\65\2\u01cf\u01d0\5\63\32\2\u01d0\u01d1\5\63\32\2\u01d1\u01d3\3\2\2\2"+
		"\u01d2\u01c7\3\2\2\2\u01d2\u01c9\3\2\2\2\u01d2\u01cd\3\2\2\2\u01d3h\3"+
		"\2\2\2\u01d4\u01d5\t\20\2\2\u01d5j\3\2\2\2\u01d6\u01d8\7^\2\2\u01d7\u01d9"+
		"\7w\2\2\u01d8\u01d7\3\2\2\2\u01d9\u01da\3\2\2\2\u01da\u01d8\3\2\2\2\u01da"+
		"\u01db\3\2\2\2\u01db\u01dc\3\2\2\2\u01dc\u01dd\5)\25\2\u01dd\u01de\5)"+
		"\25\2\u01de\u01df\5)\25\2\u01df\u01e0\5)\25\2\u01e0l\3\2\2\2\u01e1\u01e2"+
		"\7p\2\2\u01e2\u01e3\7w\2\2\u01e3\u01e4\7n\2\2\u01e4\u01e5\7n\2\2\u01e5"+
		"n\3\2\2\2\u01e6\u01e7\7*\2\2\u01e7p\3\2\2\2\u01e8\u01e9\7+\2\2\u01e9r"+
		"\3\2\2\2\u01ea\u01eb\7}\2\2\u01ebt\3\2\2\2\u01ec\u01ed\7\177\2\2\u01ed"+
		"v\3\2\2\2\u01ee\u01ef\7]\2\2\u01efx\3\2\2\2\u01f0\u01f1\7_\2\2\u01f1z"+
		"\3\2\2\2\u01f2\u01f3\7=\2\2\u01f3|\3\2\2\2\u01f4\u01f5\7\60\2\2\u01f5"+
		"~\3\2\2\2\u01f6\u01f7\7&\2\2\u01f7\u0080\3\2\2\2\u01f8\u01f9\7.\2\2\u01f9"+
		"\u0082\3\2\2\2\u01fa\u01fb\7/\2\2\u01fb\u01fc\7@\2\2\u01fc\u0084\3\2\2"+
		"\2\u01fd\u01fe\7?\2\2\u01fe\u0086\3\2\2\2\u01ff\u0200\7@\2\2\u0200\u0088"+
		"\3\2\2\2\u0201\u0202\7>\2\2\u0202\u008a\3\2\2\2\u0203\u0204\7#\2\2\u0204"+
		"\u008c\3\2\2\2\u0205\u0206\7\u0080\2\2\u0206\u008e\3\2\2\2\u0207\u0208"+
		"\7A\2\2\u0208\u0090\3\2\2\2\u0209\u020a\7<\2\2\u020a\u0092\3\2\2\2\u020b"+
		"\u020c\7<\2\2\u020c\u020d\7<\2\2\u020d\u0094\3\2\2\2\u020e\u020f\7?\2"+
		"\2\u020f\u0210\7?\2\2\u0210\u0096\3\2\2\2\u0211\u0212\7>\2\2\u0212\u0213"+
		"\7?\2\2\u0213\u0098\3\2\2\2\u0214\u0215\7@\2\2\u0215\u0216\7?\2\2\u0216"+
		"\u009a\3\2\2\2\u0217\u0218\7#\2\2\u0218\u0219\7?\2\2\u0219\u009c\3\2\2"+
		"\2\u021a\u021b\7(\2\2\u021b\u021c\7(\2\2\u021c\u009e\3\2\2\2\u021d\u021e"+
		"\7~\2\2\u021e\u021f\7~\2\2\u021f\u00a0\3\2\2\2\u0220\u0221\7-\2\2\u0221"+
		"\u0222\7-\2\2\u0222\u00a2\3\2\2\2\u0223\u0224\7/\2\2\u0224\u0225\7/\2"+
		"\2\u0225\u00a4\3\2\2\2\u0226\u0227\7-\2\2\u0227\u00a6\3\2\2\2\u0228\u0229"+
		"\7/\2\2\u0229\u00a8\3\2\2\2\u022a\u022b\7,\2\2\u022b\u00aa\3\2\2\2\u022c"+
		"\u022d\7\61\2\2\u022d\u00ac\3\2\2\2\u022e\u022f\7(\2\2\u022f\u00ae\3\2"+
		"\2\2\u0230\u0231\7~\2\2\u0231\u00b0\3\2\2\2\u0232\u0233\7`\2\2\u0233\u00b2"+
		"\3\2\2\2\u0234\u0235\7\'\2\2\u0235\u00b4\3\2\2\2\u0236\u0240\5\u00b7\\"+
		"\2\u0237\u0239\5\u00bb^\2\u0238\u0237\3\2\2\2\u0239\u023c\3\2\2\2\u023a"+
		"\u0238\3\2\2\2\u023a\u023b\3\2\2\2\u023b\u023e\3\2\2\2\u023c\u023a\3\2"+
		"\2\2\u023d\u023a\3\2\2\2\u023d\u023e\3\2\2\2\u023e\u023f\3\2\2\2\u023f"+
		"\u0241\5\u00b9]\2\u0240\u023d\3\2\2\2\u0240\u0241\3\2\2\2\u0241\u00b6"+
		"\3\2\2\2\u0242\u0249\t\21\2\2\u0243\u0244\n\22\2\2\u0244\u0249\6\\\2\2"+
		"\u0245\u0246\t\23\2\2\u0246\u0247\t\24\2\2\u0247\u0249\6\\\3\2\u0248\u0242"+
		"\3\2\2\2\u0248\u0243\3\2\2\2\u0248\u0245\3\2\2\2\u0249\u00b8\3\2\2\2\u024a"+
		"\u0251\t\25\2\2\u024b\u024c\n\22\2\2\u024c\u0251\6]\4\2\u024d\u024e\t"+
		"\23\2\2\u024e\u024f\t\24\2\2\u024f\u0251\6]\5\2\u0250\u024a\3\2\2\2\u0250"+
		"\u024b\3\2\2\2\u0250\u024d\3\2\2\2\u0251\u00ba\3\2\2\2\u0252\u0259\t\26"+
		"\2\2\u0253\u0254\n\22\2\2\u0254\u0259\6^\6\2\u0255\u0256\t\23\2\2\u0256"+
		"\u0257\t\24\2\2\u0257\u0259\6^\7\2\u0258\u0252\3\2\2\2\u0258\u0253\3\2"+
		"\2\2\u0258\u0255\3\2\2\2\u0259\u00bc\3\2\2\2\u025a\u025c\t\27\2\2\u025b"+
		"\u025a\3\2\2\2\u025c\u025d\3\2\2\2\u025d\u025b\3\2\2\2\u025d\u025e\3\2"+
		"\2\2\u025e\u025f\3\2\2\2\u025f\u0260\b_\2\2\u0260\u00be\3\2\2\2\u0261"+
		"\u0262\7\61\2\2\u0262\u0263\7,\2\2\u0263\u0267\3\2\2\2\u0264\u0266\13"+
		"\2\2\2\u0265\u0264\3\2\2\2\u0266\u0269\3\2\2\2\u0267\u0268\3\2\2\2\u0267"+
		"\u0265\3\2\2\2\u0268\u026a\3\2\2\2\u0269\u0267\3\2\2\2\u026a\u026b\7,"+
		"\2\2\u026b\u026c\7\61\2\2\u026c\u026d\3\2\2\2\u026d\u026e\b`\3\2\u026e"+
		"\u00c0\3\2\2\2\u026f\u0270\7\61\2\2\u0270\u0271\7\61\2\2\u0271\u0275\3"+
		"\2\2\2\u0272\u0274\n\30\2\2\u0273\u0272\3\2\2\2\u0274\u0277\3\2\2\2\u0275"+
		"\u0273\3\2\2\2\u0275\u0276\3\2\2\2\u0276\u0278\3\2\2\2\u0277\u0275\3\2"+
		"\2\2\u0278\u0279\ba\3\2\u0279\u00c2\3\2\2\2<\2\u00d6\u00da\u00de\u00e2"+
		"\u00e6\u00ed\u00f2\u00f4\u00f8\u00fb\u00ff\u0106\u010a\u010f\u0117\u011a"+
		"\u0121\u0125\u0129\u012f\u0132\u0139\u013d\u0145\u0148\u014f\u0153\u0157"+
		"\u015c\u015f\u0162\u0167\u016a\u016f\u0174\u017c\u0187\u018b\u0190\u0194"+
		"\u01a4\u01ae\u01b4\u01bb\u01bf\u01c5\u01d2\u01da\u023a\u023d\u0240\u0248"+
		"\u0250\u0258\u025d\u0267\u0275\4\b\2\2\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}