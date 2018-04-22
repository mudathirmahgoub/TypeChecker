// Generated from SystemF.g4 by ANTLR 4.7.1
package parser.antlr;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SystemFLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, SubBase=6, Turnstile=7, EmptyContext=8, 
		ForAll=9, Arrow=10, Lambda=11, Identifier=12, IdentifierLetter=13, Digit=14, 
		LineComment=15, WhiteSpace=16, AnyCharacter=17;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "SubBase", "Turnstile", "EmptyContext", 
		"ForAll", "Arrow", "Lambda", "Identifier", "IdentifierLetter", "Digit", 
		"LineComment", "WhiteSpace", "AnyCharacter"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'('", "','", "')'", "';'", "':'", "'SubBase'", null, "'.'", "'\\forall'", 
		null, "'\\lambda'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, "SubBase", "Turnstile", "EmptyContext", 
		"ForAll", "Arrow", "Lambda", "Identifier", "IdentifierLetter", "Digit", 
		"LineComment", "WhiteSpace", "AnyCharacter"
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


	public SystemFLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "SystemF.g4"; }

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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\23\u0082\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b@\n\b\3\t\3\t\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\5\13Y\n\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r"+
		"\7\rf\n\r\f\r\16\ri\13\r\3\16\3\16\3\17\3\17\3\20\3\20\7\20q\n\20\f\20"+
		"\16\20t\13\20\3\20\3\20\3\20\3\20\3\21\6\21{\n\21\r\21\16\21|\3\21\3\21"+
		"\3\22\3\22\3r\2\23\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r"+
		"\31\16\33\17\35\20\37\21!\22#\23\3\2\4\5\2C\\aac|\5\2\13\13\17\17\"\""+
		"\2\u0087\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2"+
		"\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27"+
		"\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2"+
		"\2\2#\3\2\2\2\3%\3\2\2\2\5\'\3\2\2\2\7)\3\2\2\2\t+\3\2\2\2\13-\3\2\2\2"+
		"\r/\3\2\2\2\17?\3\2\2\2\21A\3\2\2\2\23C\3\2\2\2\25X\3\2\2\2\27Z\3\2\2"+
		"\2\31b\3\2\2\2\33j\3\2\2\2\35l\3\2\2\2\37n\3\2\2\2!z\3\2\2\2#\u0080\3"+
		"\2\2\2%&\7*\2\2&\4\3\2\2\2\'(\7.\2\2(\6\3\2\2\2)*\7+\2\2*\b\3\2\2\2+,"+
		"\7=\2\2,\n\3\2\2\2-.\7<\2\2.\f\3\2\2\2/\60\7U\2\2\60\61\7w\2\2\61\62\7"+
		"d\2\2\62\63\7D\2\2\63\64\7c\2\2\64\65\7u\2\2\65\66\7g\2\2\66\16\3\2\2"+
		"\2\678\7~\2\28@\7/\2\29:\7^\2\2:;\7x\2\2;<\7f\2\2<=\7c\2\2=>\7u\2\2>@"+
		"\7j\2\2?\67\3\2\2\2?9\3\2\2\2@\20\3\2\2\2AB\7\60\2\2B\22\3\2\2\2CD\7^"+
		"\2\2DE\7h\2\2EF\7q\2\2FG\7t\2\2GH\7c\2\2HI\7n\2\2IJ\7n\2\2J\24\3\2\2\2"+
		"KL\7/\2\2LY\7@\2\2MN\7^\2\2NO\7t\2\2OP\7k\2\2PQ\7i\2\2QR\7j\2\2RS\7v\2"+
		"\2ST\7c\2\2TU\7t\2\2UV\7t\2\2VW\7q\2\2WY\7y\2\2XK\3\2\2\2XM\3\2\2\2Y\26"+
		"\3\2\2\2Z[\7^\2\2[\\\7n\2\2\\]\7c\2\2]^\7o\2\2^_\7d\2\2_`\7f\2\2`a\7c"+
		"\2\2a\30\3\2\2\2bg\5\33\16\2cf\5\33\16\2df\5\35\17\2ec\3\2\2\2ed\3\2\2"+
		"\2fi\3\2\2\2ge\3\2\2\2gh\3\2\2\2h\32\3\2\2\2ig\3\2\2\2jk\t\2\2\2k\34\3"+
		"\2\2\2lm\4\62;\2m\36\3\2\2\2nr\7\'\2\2oq\13\2\2\2po\3\2\2\2qt\3\2\2\2"+
		"rs\3\2\2\2rp\3\2\2\2su\3\2\2\2tr\3\2\2\2uv\7\f\2\2vw\3\2\2\2wx\b\20\2"+
		"\2x \3\2\2\2y{\t\3\2\2zy\3\2\2\2{|\3\2\2\2|z\3\2\2\2|}\3\2\2\2}~\3\2\2"+
		"\2~\177\b\21\2\2\177\"\3\2\2\2\u0080\u0081\13\2\2\2\u0081$\3\2\2\2\t\2"+
		"?Xegr|\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}