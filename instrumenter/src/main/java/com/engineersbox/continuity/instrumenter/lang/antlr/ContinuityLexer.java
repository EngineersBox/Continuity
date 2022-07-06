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
		CTX=1, EXT=2, FN=3, STD=4, IF=5, ELSE=6, IntegerLiteral=7, FloatingPointLiteral=8, 
		BooleanLiteral=9, CharacterLiteral=10, StringLiteral=11, NullLiteral=12, 
		LPAREN=13, RPAREN=14, LBRACE=15, RBRACE=16, LBRACK=17, RBRACK=18, SEMI=19, 
		DOT=20, DOLLAR=21, COMMA=22, ARROW=23, ASSIGN=24, GT=25, LT=26, BANG=27, 
		TILDE=28, QUESTION=29, COLON=30, COLONCOLON=31, EQUAL=32, LE=33, GE=34, 
		NOTEQUAL=35, AND=36, OR=37, INC=38, DEC=39, ADD=40, SUB=41, MUL=42, DIV=43, 
		BITAND=44, BITOR=45, CARET=46, MOD=47, Identifier=48, WS=49, COMMENT=50, 
		LINE_COMMENT=51;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"CTX", "EXT", "FN", "STD", "IF", "ELSE", "IntegerLiteral", "DecimalIntegerLiteral", 
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
		"CARET", "MOD", "Identifier", "Letter", "LetterOrDigit", "WS", "COMMENT", 
		"LINE_COMMENT"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'ctx'", "'ext'", "'fn'", "'std'", "'if'", "'else'", null, null, 
		null, null, null, "'null'", "'('", "')'", "'{'", "'}'", "'['", "']'", 
		"';'", "'.'", "'$'", "','", "'->'", "'='", "'>'", "'<'", "'!'", "'~'", 
		"'?'", "':'", "'::'", "'=='", "'<='", "'>='", "'!='", "'&&'", "'||'", 
		"'++'", "'--'", "'+'", "'-'", "'*'", "'/'", "'&'", "'|'", "'^'", "'%'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "CTX", "EXT", "FN", "STD", "IF", "ELSE", "IntegerLiteral", "FloatingPointLiteral", 
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
		case 92:
			return Letter_sempred((RuleContext)_localctx, predIndex);
		case 93:
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
	private boolean LetterOrDigit_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return  checkSupportedSingletonCharacters() ;
		case 3:
			return  checkSupportedSurrogatePairCharacters() ;
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\65\u0277\b\1\4\2"+
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
		"\4`\t`\4a\ta\4b\tb\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\5\3\5"+
		"\3\5\3\5\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\5\b\u00e1\n\b"+
		"\3\t\3\t\5\t\u00e5\n\t\3\n\3\n\5\n\u00e9\n\n\3\13\3\13\5\13\u00ed\n\13"+
		"\3\f\3\f\5\f\u00f1\n\f\3\r\3\r\3\16\3\16\3\16\5\16\u00f8\n\16\3\16\3\16"+
		"\3\16\5\16\u00fd\n\16\5\16\u00ff\n\16\3\17\3\17\5\17\u0103\n\17\3\17\5"+
		"\17\u0106\n\17\3\20\3\20\5\20\u010a\n\20\3\21\3\21\3\22\6\22\u010f\n\22"+
		"\r\22\16\22\u0110\3\23\3\23\5\23\u0115\n\23\3\24\6\24\u0118\n\24\r\24"+
		"\16\24\u0119\3\25\3\25\3\25\3\25\3\26\3\26\5\26\u0122\n\26\3\26\5\26\u0125"+
		"\n\26\3\27\3\27\3\30\6\30\u012a\n\30\r\30\16\30\u012b\3\31\3\31\5\31\u0130"+
		"\n\31\3\32\3\32\5\32\u0134\n\32\3\32\3\32\3\33\3\33\5\33\u013a\n\33\3"+
		"\33\5\33\u013d\n\33\3\34\3\34\3\35\6\35\u0142\n\35\r\35\16\35\u0143\3"+
		"\36\3\36\5\36\u0148\n\36\3\37\3\37\3\37\3\37\3 \3 \5 \u0150\n \3 \5 \u0153"+
		"\n \3!\3!\3\"\6\"\u0158\n\"\r\"\16\"\u0159\3#\3#\5#\u015e\n#\3$\3$\5$"+
		"\u0162\n$\3%\3%\3%\5%\u0167\n%\3%\5%\u016a\n%\3%\5%\u016d\n%\3%\3%\3%"+
		"\5%\u0172\n%\3%\5%\u0175\n%\3%\3%\3%\5%\u017a\n%\3%\3%\3%\5%\u017f\n%"+
		"\3&\3&\3&\3\'\3\'\3(\5(\u0187\n(\3(\3(\3)\3)\3*\3*\3+\3+\3+\5+\u0192\n"+
		"+\3,\3,\5,\u0196\n,\3,\3,\3,\5,\u019b\n,\3,\3,\5,\u019f\n,\3-\3-\3-\3"+
		".\3.\3/\3/\3/\3/\3/\3/\3/\3/\3/\5/\u01af\n/\3\60\3\60\3\60\3\60\3\60\3"+
		"\60\3\60\3\60\5\60\u01b9\n\60\3\61\3\61\3\62\3\62\5\62\u01bf\n\62\3\62"+
		"\3\62\3\63\6\63\u01c4\n\63\r\63\16\63\u01c5\3\64\3\64\5\64\u01ca\n\64"+
		"\3\65\3\65\3\65\3\65\5\65\u01d0\n\65\3\66\3\66\3\66\3\66\3\66\3\66\3\66"+
		"\3\66\3\66\3\66\3\66\5\66\u01dd\n\66\3\67\3\67\38\38\68\u01e3\n8\r8\16"+
		"8\u01e4\38\38\38\38\38\39\39\39\39\39\3:\3:\3;\3;\3<\3<\3=\3=\3>\3>\3"+
		"?\3?\3@\3@\3A\3A\3B\3B\3C\3C\3D\3D\3D\3E\3E\3F\3F\3G\3G\3H\3H\3I\3I\3"+
		"J\3J\3K\3K\3L\3L\3L\3M\3M\3M\3N\3N\3N\3O\3O\3O\3P\3P\3P\3Q\3Q\3Q\3R\3"+
		"R\3R\3S\3S\3S\3T\3T\3T\3U\3U\3V\3V\3W\3W\3X\3X\3Y\3Y\3Z\3Z\3[\3[\3\\\3"+
		"\\\3]\3]\7]\u0243\n]\f]\16]\u0246\13]\3^\3^\3^\3^\3^\3^\5^\u024e\n^\3"+
		"_\3_\3_\3_\3_\3_\5_\u0256\n_\3`\6`\u0259\n`\r`\16`\u025a\3`\3`\3a\3a\3"+
		"a\3a\7a\u0263\na\fa\16a\u0266\13a\3a\3a\3a\3a\3a\3b\3b\3b\3b\7b\u0271"+
		"\nb\fb\16b\u0274\13b\3b\3b\3\u0264\2c\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21"+
		"\2\23\2\25\2\27\2\31\2\33\2\35\2\37\2!\2#\2%\2\'\2)\2+\2-\2/\2\61\2\63"+
		"\2\65\2\67\29\2;\2=\2?\2A\2C\2E\2G\nI\2K\2M\2O\2Q\2S\2U\2W\2Y\2[\2]\13"+
		"_\fa\2c\re\2g\2i\2k\2m\2o\2q\16s\17u\20w\21y\22{\23}\24\177\25\u0081\26"+
		"\u0083\27\u0085\30\u0087\31\u0089\32\u008b\33\u008d\34\u008f\35\u0091"+
		"\36\u0093\37\u0095 \u0097!\u0099\"\u009b#\u009d$\u009f%\u00a1&\u00a3\'"+
		"\u00a5(\u00a7)\u00a9*\u00ab+\u00ad,\u00af-\u00b1.\u00b3/\u00b5\60\u00b7"+
		"\61\u00b9\62\u00bb\2\u00bd\2\u00bf\63\u00c1\64\u00c3\65\3\2\30\4\2NNn"+
		"n\3\2\63;\4\2ZZzz\5\2\62;CHch\3\2\629\4\2DDdd\3\2\62\63\4\2GGgg\4\2--"+
		"//\6\2FFHHffhh\4\2RRrr\6\2\f\f\17\17))^^\6\2\f\f\17\17$$^^\n\2$$))^^d"+
		"dhhppttvv\3\2\62\65\6\2&&C\\aac|\4\2\2\u0081\ud802\udc01\3\2\ud802\udc01"+
		"\3\2\udc02\ue001\7\2&&\62;C\\aac|\5\2\13\f\16\17\"\"\4\2\f\f\17\17\2\u0286"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2G\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2c\3\2\2\2\2q\3\2\2"+
		"\2\2s\3\2\2\2\2u\3\2\2\2\2w\3\2\2\2\2y\3\2\2\2\2{\3\2\2\2\2}\3\2\2\2\2"+
		"\177\3\2\2\2\2\u0081\3\2\2\2\2\u0083\3\2\2\2\2\u0085\3\2\2\2\2\u0087\3"+
		"\2\2\2\2\u0089\3\2\2\2\2\u008b\3\2\2\2\2\u008d\3\2\2\2\2\u008f\3\2\2\2"+
		"\2\u0091\3\2\2\2\2\u0093\3\2\2\2\2\u0095\3\2\2\2\2\u0097\3\2\2\2\2\u0099"+
		"\3\2\2\2\2\u009b\3\2\2\2\2\u009d\3\2\2\2\2\u009f\3\2\2\2\2\u00a1\3\2\2"+
		"\2\2\u00a3\3\2\2\2\2\u00a5\3\2\2\2\2\u00a7\3\2\2\2\2\u00a9\3\2\2\2\2\u00ab"+
		"\3\2\2\2\2\u00ad\3\2\2\2\2\u00af\3\2\2\2\2\u00b1\3\2\2\2\2\u00b3\3\2\2"+
		"\2\2\u00b5\3\2\2\2\2\u00b7\3\2\2\2\2\u00b9\3\2\2\2\2\u00bf\3\2\2\2\2\u00c1"+
		"\3\2\2\2\2\u00c3\3\2\2\2\3\u00c5\3\2\2\2\5\u00c9\3\2\2\2\7\u00cd\3\2\2"+
		"\2\t\u00d0\3\2\2\2\13\u00d4\3\2\2\2\r\u00d7\3\2\2\2\17\u00e0\3\2\2\2\21"+
		"\u00e2\3\2\2\2\23\u00e6\3\2\2\2\25\u00ea\3\2\2\2\27\u00ee\3\2\2\2\31\u00f2"+
		"\3\2\2\2\33\u00fe\3\2\2\2\35\u0100\3\2\2\2\37\u0109\3\2\2\2!\u010b\3\2"+
		"\2\2#\u010e\3\2\2\2%\u0114\3\2\2\2\'\u0117\3\2\2\2)\u011b\3\2\2\2+\u011f"+
		"\3\2\2\2-\u0126\3\2\2\2/\u0129\3\2\2\2\61\u012f\3\2\2\2\63\u0131\3\2\2"+
		"\2\65\u0137\3\2\2\2\67\u013e\3\2\2\29\u0141\3\2\2\2;\u0147\3\2\2\2=\u0149"+
		"\3\2\2\2?\u014d\3\2\2\2A\u0154\3\2\2\2C\u0157\3\2\2\2E\u015d\3\2\2\2G"+
		"\u0161\3\2\2\2I\u017e\3\2\2\2K\u0180\3\2\2\2M\u0183\3\2\2\2O\u0186\3\2"+
		"\2\2Q\u018a\3\2\2\2S\u018c\3\2\2\2U\u018e\3\2\2\2W\u019e\3\2\2\2Y\u01a0"+
		"\3\2\2\2[\u01a3\3\2\2\2]\u01ae\3\2\2\2_\u01b8\3\2\2\2a\u01ba\3\2\2\2c"+
		"\u01bc\3\2\2\2e\u01c3\3\2\2\2g\u01c9\3\2\2\2i\u01cf\3\2\2\2k\u01dc\3\2"+
		"\2\2m\u01de\3\2\2\2o\u01e0\3\2\2\2q\u01eb\3\2\2\2s\u01f0\3\2\2\2u\u01f2"+
		"\3\2\2\2w\u01f4\3\2\2\2y\u01f6\3\2\2\2{\u01f8\3\2\2\2}\u01fa\3\2\2\2\177"+
		"\u01fc\3\2\2\2\u0081\u01fe\3\2\2\2\u0083\u0200\3\2\2\2\u0085\u0202\3\2"+
		"\2\2\u0087\u0204\3\2\2\2\u0089\u0207\3\2\2\2\u008b\u0209\3\2\2\2\u008d"+
		"\u020b\3\2\2\2\u008f\u020d\3\2\2\2\u0091\u020f\3\2\2\2\u0093\u0211\3\2"+
		"\2\2\u0095\u0213\3\2\2\2\u0097\u0215\3\2\2\2\u0099\u0218\3\2\2\2\u009b"+
		"\u021b\3\2\2\2\u009d\u021e\3\2\2\2\u009f\u0221\3\2\2\2\u00a1\u0224\3\2"+
		"\2\2\u00a3\u0227\3\2\2\2\u00a5\u022a\3\2\2\2\u00a7\u022d\3\2\2\2\u00a9"+
		"\u0230\3\2\2\2\u00ab\u0232\3\2\2\2\u00ad\u0234\3\2\2\2\u00af\u0236\3\2"+
		"\2\2\u00b1\u0238\3\2\2\2\u00b3\u023a\3\2\2\2\u00b5\u023c\3\2\2\2\u00b7"+
		"\u023e\3\2\2\2\u00b9\u0240\3\2\2\2\u00bb\u024d\3\2\2\2\u00bd\u0255\3\2"+
		"\2\2\u00bf\u0258\3\2\2\2\u00c1\u025e\3\2\2\2\u00c3\u026c\3\2\2\2\u00c5"+
		"\u00c6\7e\2\2\u00c6\u00c7\7v\2\2\u00c7\u00c8\7z\2\2\u00c8\4\3\2\2\2\u00c9"+
		"\u00ca\7g\2\2\u00ca\u00cb\7z\2\2\u00cb\u00cc\7v\2\2\u00cc\6\3\2\2\2\u00cd"+
		"\u00ce\7h\2\2\u00ce\u00cf\7p\2\2\u00cf\b\3\2\2\2\u00d0\u00d1\7u\2\2\u00d1"+
		"\u00d2\7v\2\2\u00d2\u00d3\7f\2\2\u00d3\n\3\2\2\2\u00d4\u00d5\7k\2\2\u00d5"+
		"\u00d6\7h\2\2\u00d6\f\3\2\2\2\u00d7\u00d8\7g\2\2\u00d8\u00d9\7n\2\2\u00d9"+
		"\u00da\7u\2\2\u00da\u00db\7g\2\2\u00db\16\3\2\2\2\u00dc\u00e1\5\21\t\2"+
		"\u00dd\u00e1\5\23\n\2\u00de\u00e1\5\25\13\2\u00df\u00e1\5\27\f\2\u00e0"+
		"\u00dc\3\2\2\2\u00e0\u00dd\3\2\2\2\u00e0\u00de\3\2\2\2\u00e0\u00df\3\2"+
		"\2\2\u00e1\20\3\2\2\2\u00e2\u00e4\5\33\16\2\u00e3\u00e5\5\31\r\2\u00e4"+
		"\u00e3\3\2\2\2\u00e4\u00e5\3\2\2\2\u00e5\22\3\2\2\2\u00e6\u00e8\5)\25"+
		"\2\u00e7\u00e9\5\31\r\2\u00e8\u00e7\3\2\2\2\u00e8\u00e9\3\2\2\2\u00e9"+
		"\24\3\2\2\2\u00ea\u00ec\5\63\32\2\u00eb\u00ed\5\31\r\2\u00ec\u00eb\3\2"+
		"\2\2\u00ec\u00ed\3\2\2\2\u00ed\26\3\2\2\2\u00ee\u00f0\5=\37\2\u00ef\u00f1"+
		"\5\31\r\2\u00f0\u00ef\3\2\2\2\u00f0\u00f1\3\2\2\2\u00f1\30\3\2\2\2\u00f2"+
		"\u00f3\t\2\2\2\u00f3\32\3\2\2\2\u00f4\u00ff\7\62\2\2\u00f5\u00fc\5!\21"+
		"\2\u00f6\u00f8\5\35\17\2\u00f7\u00f6\3\2\2\2\u00f7\u00f8\3\2\2\2\u00f8"+
		"\u00fd\3\2\2\2\u00f9\u00fa\5\'\24\2\u00fa\u00fb\5\35\17\2\u00fb\u00fd"+
		"\3\2\2\2\u00fc\u00f7\3\2\2\2\u00fc\u00f9\3\2\2\2\u00fd\u00ff\3\2\2\2\u00fe"+
		"\u00f4\3\2\2\2\u00fe\u00f5\3\2\2\2\u00ff\34\3\2\2\2\u0100\u0105\5\37\20"+
		"\2\u0101\u0103\5#\22\2\u0102\u0101\3\2\2\2\u0102\u0103\3\2\2\2\u0103\u0104"+
		"\3\2\2\2\u0104\u0106\5\37\20\2\u0105\u0102\3\2\2\2\u0105\u0106\3\2\2\2"+
		"\u0106\36\3\2\2\2\u0107\u010a\7\62\2\2\u0108\u010a\5!\21\2\u0109\u0107"+
		"\3\2\2\2\u0109\u0108\3\2\2\2\u010a \3\2\2\2\u010b\u010c\t\3\2\2\u010c"+
		"\"\3\2\2\2\u010d\u010f\5%\23\2\u010e\u010d\3\2\2\2\u010f\u0110\3\2\2\2"+
		"\u0110\u010e\3\2\2\2\u0110\u0111\3\2\2\2\u0111$\3\2\2\2\u0112\u0115\5"+
		"\37\20\2\u0113\u0115\7a\2\2\u0114\u0112\3\2\2\2\u0114\u0113\3\2\2\2\u0115"+
		"&\3\2\2\2\u0116\u0118\7a\2\2\u0117\u0116\3\2\2\2\u0118\u0119\3\2\2\2\u0119"+
		"\u0117\3\2\2\2\u0119\u011a\3\2\2\2\u011a(\3\2\2\2\u011b\u011c\7\62\2\2"+
		"\u011c\u011d\t\4\2\2\u011d\u011e\5+\26\2\u011e*\3\2\2\2\u011f\u0124\5"+
		"-\27\2\u0120\u0122\5/\30\2\u0121\u0120\3\2\2\2\u0121\u0122\3\2\2\2\u0122"+
		"\u0123\3\2\2\2\u0123\u0125\5-\27\2\u0124\u0121\3\2\2\2\u0124\u0125\3\2"+
		"\2\2\u0125,\3\2\2\2\u0126\u0127\t\5\2\2\u0127.\3\2\2\2\u0128\u012a\5\61"+
		"\31\2\u0129\u0128\3\2\2\2\u012a\u012b\3\2\2\2\u012b\u0129\3\2\2\2\u012b"+
		"\u012c\3\2\2\2\u012c\60\3\2\2\2\u012d\u0130\5-\27\2\u012e\u0130\7a\2\2"+
		"\u012f\u012d\3\2\2\2\u012f\u012e\3\2\2\2\u0130\62\3\2\2\2\u0131\u0133"+
		"\7\62\2\2\u0132\u0134\5\'\24\2\u0133\u0132\3\2\2\2\u0133\u0134\3\2\2\2"+
		"\u0134\u0135\3\2\2\2\u0135\u0136\5\65\33\2\u0136\64\3\2\2\2\u0137\u013c"+
		"\5\67\34\2\u0138\u013a\59\35\2\u0139\u0138\3\2\2\2\u0139\u013a\3\2\2\2"+
		"\u013a\u013b\3\2\2\2\u013b\u013d\5\67\34\2\u013c\u0139\3\2\2\2\u013c\u013d"+
		"\3\2\2\2\u013d\66\3\2\2\2\u013e\u013f\t\6\2\2\u013f8\3\2\2\2\u0140\u0142"+
		"\5;\36\2\u0141\u0140\3\2\2\2\u0142\u0143\3\2\2\2\u0143\u0141\3\2\2\2\u0143"+
		"\u0144\3\2\2\2\u0144:\3\2\2\2\u0145\u0148\5\67\34\2\u0146\u0148\7a\2\2"+
		"\u0147\u0145\3\2\2\2\u0147\u0146\3\2\2\2\u0148<\3\2\2\2\u0149\u014a\7"+
		"\62\2\2\u014a\u014b\t\7\2\2\u014b\u014c\5? \2\u014c>\3\2\2\2\u014d\u0152"+
		"\5A!\2\u014e\u0150\5C\"\2\u014f\u014e\3\2\2\2\u014f\u0150\3\2\2\2\u0150"+
		"\u0151\3\2\2\2\u0151\u0153\5A!\2\u0152\u014f\3\2\2\2\u0152\u0153\3\2\2"+
		"\2\u0153@\3\2\2\2\u0154\u0155\t\b\2\2\u0155B\3\2\2\2\u0156\u0158\5E#\2"+
		"\u0157\u0156\3\2\2\2\u0158\u0159\3\2\2\2\u0159\u0157\3\2\2\2\u0159\u015a"+
		"\3\2\2\2\u015aD\3\2\2\2\u015b\u015e\5A!\2\u015c\u015e\7a\2\2\u015d\u015b"+
		"\3\2\2\2\u015d\u015c\3\2\2\2\u015eF\3\2\2\2\u015f\u0162\5I%\2\u0160\u0162"+
		"\5U+\2\u0161\u015f\3\2\2\2\u0161\u0160\3\2\2\2\u0162H\3\2\2\2\u0163\u0164"+
		"\5\35\17\2\u0164\u0166\7\60\2\2\u0165\u0167\5\35\17\2\u0166\u0165\3\2"+
		"\2\2\u0166\u0167\3\2\2\2\u0167\u0169\3\2\2\2\u0168\u016a\5K&\2\u0169\u0168"+
		"\3\2\2\2\u0169\u016a\3\2\2\2\u016a\u016c\3\2\2\2\u016b\u016d\5S*\2\u016c"+
		"\u016b\3\2\2\2\u016c\u016d\3\2\2\2\u016d\u017f\3\2\2\2\u016e\u016f\7\60"+
		"\2\2\u016f\u0171\5\35\17\2\u0170\u0172\5K&\2\u0171\u0170\3\2\2\2\u0171"+
		"\u0172\3\2\2\2\u0172\u0174\3\2\2\2\u0173\u0175\5S*\2\u0174\u0173\3\2\2"+
		"\2\u0174\u0175\3\2\2\2\u0175\u017f\3\2\2\2\u0176\u0177\5\35\17\2\u0177"+
		"\u0179\5K&\2\u0178\u017a\5S*\2\u0179\u0178\3\2\2\2\u0179\u017a\3\2\2\2"+
		"\u017a\u017f\3\2\2\2\u017b\u017c\5\35\17\2\u017c\u017d\5S*\2\u017d\u017f"+
		"\3\2\2\2\u017e\u0163\3\2\2\2\u017e\u016e\3\2\2\2\u017e\u0176\3\2\2\2\u017e"+
		"\u017b\3\2\2\2\u017fJ\3\2\2\2\u0180\u0181\5M\'\2\u0181\u0182\5O(\2\u0182"+
		"L\3\2\2\2\u0183\u0184\t\t\2\2\u0184N\3\2\2\2\u0185\u0187\5Q)\2\u0186\u0185"+
		"\3\2\2\2\u0186\u0187\3\2\2\2\u0187\u0188\3\2\2\2\u0188\u0189\5\35\17\2"+
		"\u0189P\3\2\2\2\u018a\u018b\t\n\2\2\u018bR\3\2\2\2\u018c\u018d\t\13\2"+
		"\2\u018dT\3\2\2\2\u018e\u018f\5W,\2\u018f\u0191\5Y-\2\u0190\u0192\5S*"+
		"\2\u0191\u0190\3\2\2\2\u0191\u0192\3\2\2\2\u0192V\3\2\2\2\u0193\u0195"+
		"\5)\25\2\u0194\u0196\7\60\2\2\u0195\u0194\3\2\2\2\u0195\u0196\3\2\2\2"+
		"\u0196\u019f\3\2\2\2\u0197\u0198\7\62\2\2\u0198\u019a\t\4\2\2\u0199\u019b"+
		"\5+\26\2\u019a\u0199\3\2\2\2\u019a\u019b\3\2\2\2\u019b\u019c\3\2\2\2\u019c"+
		"\u019d\7\60\2\2\u019d\u019f\5+\26\2\u019e\u0193\3\2\2\2\u019e\u0197\3"+
		"\2\2\2\u019fX\3\2\2\2\u01a0\u01a1\5[.\2\u01a1\u01a2\5O(\2\u01a2Z\3\2\2"+
		"\2\u01a3\u01a4\t\f\2\2\u01a4\\\3\2\2\2\u01a5\u01a6\7v\2\2\u01a6\u01a7"+
		"\7t\2\2\u01a7\u01a8\7w\2\2\u01a8\u01af\7g\2\2\u01a9\u01aa\7h\2\2\u01aa"+
		"\u01ab\7c\2\2\u01ab\u01ac\7n\2\2\u01ac\u01ad\7u\2\2\u01ad\u01af\7g\2\2"+
		"\u01ae\u01a5\3\2\2\2\u01ae\u01a9\3\2\2\2\u01af^\3\2\2\2\u01b0\u01b1\7"+
		")\2\2\u01b1\u01b2\5a\61\2\u01b2\u01b3\7)\2\2\u01b3\u01b9\3\2\2\2\u01b4"+
		"\u01b5\7)\2\2\u01b5\u01b6\5i\65\2\u01b6\u01b7\7)\2\2\u01b7\u01b9\3\2\2"+
		"\2\u01b8\u01b0\3\2\2\2\u01b8\u01b4\3\2\2\2\u01b9`\3\2\2\2\u01ba\u01bb"+
		"\n\r\2\2\u01bbb\3\2\2\2\u01bc\u01be\7$\2\2\u01bd\u01bf\5e\63\2\u01be\u01bd"+
		"\3\2\2\2\u01be\u01bf\3\2\2\2\u01bf\u01c0\3\2\2\2\u01c0\u01c1\7$\2\2\u01c1"+
		"d\3\2\2\2\u01c2\u01c4\5g\64\2\u01c3\u01c2\3\2\2\2\u01c4\u01c5\3\2\2\2"+
		"\u01c5\u01c3\3\2\2\2\u01c5\u01c6\3\2\2\2\u01c6f\3\2\2\2\u01c7\u01ca\n"+
		"\16\2\2\u01c8\u01ca\5i\65\2\u01c9\u01c7\3\2\2\2\u01c9\u01c8\3\2\2\2\u01ca"+
		"h\3\2\2\2\u01cb\u01cc\7^\2\2\u01cc\u01d0\t\17\2\2\u01cd\u01d0\5k\66\2"+
		"\u01ce\u01d0\5o8\2\u01cf\u01cb\3\2\2\2\u01cf\u01cd\3\2\2\2\u01cf\u01ce"+
		"\3\2\2\2\u01d0j\3\2\2\2\u01d1\u01d2\7^\2\2\u01d2\u01dd\5\67\34\2\u01d3"+
		"\u01d4\7^\2\2\u01d4\u01d5\5\67\34\2\u01d5\u01d6\5\67\34\2\u01d6\u01dd"+
		"\3\2\2\2\u01d7\u01d8\7^\2\2\u01d8\u01d9\5m\67\2\u01d9\u01da\5\67\34\2"+
		"\u01da\u01db\5\67\34\2\u01db\u01dd\3\2\2\2\u01dc\u01d1\3\2\2\2\u01dc\u01d3"+
		"\3\2\2\2\u01dc\u01d7\3\2\2\2\u01ddl\3\2\2\2\u01de\u01df\t\20\2\2\u01df"+
		"n\3\2\2\2\u01e0\u01e2\7^\2\2\u01e1\u01e3\7w\2\2\u01e2\u01e1\3\2\2\2\u01e3"+
		"\u01e4\3\2\2\2\u01e4\u01e2\3\2\2\2\u01e4\u01e5\3\2\2\2\u01e5\u01e6\3\2"+
		"\2\2\u01e6\u01e7\5-\27\2\u01e7\u01e8\5-\27\2\u01e8\u01e9\5-\27\2\u01e9"+
		"\u01ea\5-\27\2\u01eap\3\2\2\2\u01eb\u01ec\7p\2\2\u01ec\u01ed\7w\2\2\u01ed"+
		"\u01ee\7n\2\2\u01ee\u01ef\7n\2\2\u01efr\3\2\2\2\u01f0\u01f1\7*\2\2\u01f1"+
		"t\3\2\2\2\u01f2\u01f3\7+\2\2\u01f3v\3\2\2\2\u01f4\u01f5\7}\2\2\u01f5x"+
		"\3\2\2\2\u01f6\u01f7\7\177\2\2\u01f7z\3\2\2\2\u01f8\u01f9\7]\2\2\u01f9"+
		"|\3\2\2\2\u01fa\u01fb\7_\2\2\u01fb~\3\2\2\2\u01fc\u01fd\7=\2\2\u01fd\u0080"+
		"\3\2\2\2\u01fe\u01ff\7\60\2\2\u01ff\u0082\3\2\2\2\u0200\u0201\7&\2\2\u0201"+
		"\u0084\3\2\2\2\u0202\u0203\7.\2\2\u0203\u0086\3\2\2\2\u0204\u0205\7/\2"+
		"\2\u0205\u0206\7@\2\2\u0206\u0088\3\2\2\2\u0207\u0208\7?\2\2\u0208\u008a"+
		"\3\2\2\2\u0209\u020a\7@\2\2\u020a\u008c\3\2\2\2\u020b\u020c\7>\2\2\u020c"+
		"\u008e\3\2\2\2\u020d\u020e\7#\2\2\u020e\u0090\3\2\2\2\u020f\u0210\7\u0080"+
		"\2\2\u0210\u0092\3\2\2\2\u0211\u0212\7A\2\2\u0212\u0094\3\2\2\2\u0213"+
		"\u0214\7<\2\2\u0214\u0096\3\2\2\2\u0215\u0216\7<\2\2\u0216\u0217\7<\2"+
		"\2\u0217\u0098\3\2\2\2\u0218\u0219\7?\2\2\u0219\u021a\7?\2\2\u021a\u009a"+
		"\3\2\2\2\u021b\u021c\7>\2\2\u021c\u021d\7?\2\2\u021d\u009c\3\2\2\2\u021e"+
		"\u021f\7@\2\2\u021f\u0220\7?\2\2\u0220\u009e\3\2\2\2\u0221\u0222\7#\2"+
		"\2\u0222\u0223\7?\2\2\u0223\u00a0\3\2\2\2\u0224\u0225\7(\2\2\u0225\u0226"+
		"\7(\2\2\u0226\u00a2\3\2\2\2\u0227\u0228\7~\2\2\u0228\u0229\7~\2\2\u0229"+
		"\u00a4\3\2\2\2\u022a\u022b\7-\2\2\u022b\u022c\7-\2\2\u022c\u00a6\3\2\2"+
		"\2\u022d\u022e\7/\2\2\u022e\u022f\7/\2\2\u022f\u00a8\3\2\2\2\u0230\u0231"+
		"\7-\2\2\u0231\u00aa\3\2\2\2\u0232\u0233\7/\2\2\u0233\u00ac\3\2\2\2\u0234"+
		"\u0235\7,\2\2\u0235\u00ae\3\2\2\2\u0236\u0237\7\61\2\2\u0237\u00b0\3\2"+
		"\2\2\u0238\u0239\7(\2\2\u0239\u00b2\3\2\2\2\u023a\u023b\7~\2\2\u023b\u00b4"+
		"\3\2\2\2\u023c\u023d\7`\2\2\u023d\u00b6\3\2\2\2\u023e\u023f\7\'\2\2\u023f"+
		"\u00b8\3\2\2\2\u0240\u0244\5\u00bb^\2\u0241\u0243\5\u00bd_\2\u0242\u0241"+
		"\3\2\2\2\u0243\u0246\3\2\2\2\u0244\u0242\3\2\2\2\u0244\u0245\3\2\2\2\u0245"+
		"\u00ba\3\2\2\2\u0246\u0244\3\2\2\2\u0247\u024e\t\21\2\2\u0248\u0249\n"+
		"\22\2\2\u0249\u024e\6^\2\2\u024a\u024b\t\23\2\2\u024b\u024c\t\24\2\2\u024c"+
		"\u024e\6^\3\2\u024d\u0247\3\2\2\2\u024d\u0248\3\2\2\2\u024d\u024a\3\2"+
		"\2\2\u024e\u00bc\3\2\2\2\u024f\u0256\t\25\2\2\u0250\u0251\n\22\2\2\u0251"+
		"\u0256\6_\4\2\u0252\u0253\t\23\2\2\u0253\u0254\t\24\2\2\u0254\u0256\6"+
		"_\5\2\u0255\u024f\3\2\2\2\u0255\u0250\3\2\2\2\u0255\u0252\3\2\2\2\u0256"+
		"\u00be\3\2\2\2\u0257\u0259\t\26\2\2\u0258\u0257\3\2\2\2\u0259\u025a\3"+
		"\2\2\2\u025a\u0258\3\2\2\2\u025a\u025b\3\2\2\2\u025b\u025c\3\2\2\2\u025c"+
		"\u025d\b`\2\2\u025d\u00c0\3\2\2\2\u025e\u025f\7\61\2\2\u025f\u0260\7,"+
		"\2\2\u0260\u0264\3\2\2\2\u0261\u0263\13\2\2\2\u0262\u0261\3\2\2\2\u0263"+
		"\u0266\3\2\2\2\u0264\u0265\3\2\2\2\u0264\u0262\3\2\2\2\u0265\u0267\3\2"+
		"\2\2\u0266\u0264\3\2\2\2\u0267\u0268\7,\2\2\u0268\u0269\7\61\2\2\u0269"+
		"\u026a\3\2\2\2\u026a\u026b\ba\3\2\u026b\u00c2\3\2\2\2\u026c\u026d\7\61"+
		"\2\2\u026d\u026e\7\61\2\2\u026e\u0272\3\2\2\2\u026f\u0271\n\27\2\2\u0270"+
		"\u026f\3\2\2\2\u0271\u0274\3\2\2\2\u0272\u0270\3\2\2\2\u0272\u0273\3\2"+
		"\2\2\u0273\u0275\3\2\2\2\u0274\u0272\3\2\2\2\u0275\u0276\bb\3\2\u0276"+
		"\u00c4\3\2\2\29\2\u00e0\u00e4\u00e8\u00ec\u00f0\u00f7\u00fc\u00fe\u0102"+
		"\u0105\u0109\u0110\u0114\u0119\u0121\u0124\u012b\u012f\u0133\u0139\u013c"+
		"\u0143\u0147\u014f\u0152\u0159\u015d\u0161\u0166\u0169\u016c\u0171\u0174"+
		"\u0179\u017e\u0186\u0191\u0195\u019a\u019e\u01ae\u01b8\u01be\u01c5\u01c9"+
		"\u01cf\u01dc\u01e4\u0244\u024d\u0255\u025a\u0264\u0272\4\b\2\2\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}