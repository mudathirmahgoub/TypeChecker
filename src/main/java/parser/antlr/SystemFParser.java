// Generated from SystemF.g4 by ANTLR 4.7.1
package parser.antlr;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SystemFParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, SubBase=8, Turnstile=9, 
		EmptyContext=10, ForAll=11, Arrow=12, Lambda=13, Identifier=14, IdentifierLetter=15, 
		Digit=16, LineComment=17, WhiteSpace=18, AnyCharacter=19;
	public static final int
		RULE_systemF = 0, RULE_subtype = 1, RULE_judgment = 2, RULE_typingContext = 3, 
		RULE_type = 4, RULE_term = 5;
	public static final String[] ruleNames = {
		"systemF", "subtype", "judgment", "typingContext", "type", "term"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'('", "','", "')'", "';'", "':'", "'['", "']'", "'SubBase'", null, 
		"'.'", "'\\forall'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, "SubBase", "Turnstile", 
		"EmptyContext", "ForAll", "Arrow", "Lambda", "Identifier", "IdentifierLetter", 
		"Digit", "LineComment", "WhiteSpace", "AnyCharacter"
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
	public String getGrammarFileName() { return "SystemF.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public SystemFParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class SystemFContext extends ParserRuleContext {
		public JudgmentContext judgment() {
			return getRuleContext(JudgmentContext.class,0);
		}
		public List<SubtypeContext> subtype() {
			return getRuleContexts(SubtypeContext.class);
		}
		public SubtypeContext subtype(int i) {
			return getRuleContext(SubtypeContext.class,i);
		}
		public SystemFContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_systemF; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SystemFListener ) ((SystemFListener)listener).enterSystemF(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SystemFListener ) ((SystemFListener)listener).exitSystemF(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SystemFVisitor ) return ((SystemFVisitor<? extends T>)visitor).visitSystemF(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SystemFContext systemF() throws RecognitionException {
		SystemFContext _localctx = new SystemFContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_systemF);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(15);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SubBase) {
				{
				{
				setState(12);
				subtype();
				}
				}
				setState(17);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(18);
			judgment();
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

	public static class SubtypeContext extends ParserRuleContext {
		public TerminalNode SubBase() { return getToken(SystemFParser.SubBase, 0); }
		public List<TerminalNode> Identifier() { return getTokens(SystemFParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(SystemFParser.Identifier, i);
		}
		public SubtypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subtype; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SystemFListener ) ((SystemFListener)listener).enterSubtype(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SystemFListener ) ((SystemFListener)listener).exitSubtype(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SystemFVisitor ) return ((SystemFVisitor<? extends T>)visitor).visitSubtype(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SubtypeContext subtype() throws RecognitionException {
		SubtypeContext _localctx = new SubtypeContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_subtype);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(20);
			match(SubBase);
			setState(21);
			match(T__0);
			setState(22);
			match(Identifier);
			setState(23);
			match(T__1);
			setState(24);
			match(Identifier);
			setState(25);
			match(T__2);
			setState(26);
			match(T__3);
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

	public static class JudgmentContext extends ParserRuleContext {
		public TypingContextContext typingContext() {
			return getRuleContext(TypingContextContext.class,0);
		}
		public TerminalNode Turnstile() { return getToken(SystemFParser.Turnstile, 0); }
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public JudgmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_judgment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SystemFListener ) ((SystemFListener)listener).enterJudgment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SystemFListener ) ((SystemFListener)listener).exitJudgment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SystemFVisitor ) return ((SystemFVisitor<? extends T>)visitor).visitJudgment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JudgmentContext judgment() throws RecognitionException {
		JudgmentContext _localctx = new JudgmentContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_judgment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(28);
			typingContext();
			setState(29);
			match(Turnstile);
			setState(30);
			term();
			setState(31);
			match(T__4);
			setState(32);
			type(0);
			setState(33);
			match(T__3);
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

	public static class TypingContextContext extends ParserRuleContext {
		public TerminalNode EmptyContext() { return getToken(SystemFParser.EmptyContext, 0); }
		public List<TerminalNode> Identifier() { return getTokens(SystemFParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(SystemFParser.Identifier, i);
		}
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public TypingContextContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typingContext; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SystemFListener ) ((SystemFListener)listener).enterTypingContext(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SystemFListener ) ((SystemFListener)listener).exitTypingContext(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SystemFVisitor ) return ((SystemFVisitor<? extends T>)visitor).visitTypingContext(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypingContextContext typingContext() throws RecognitionException {
		TypingContextContext _localctx = new TypingContextContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_typingContext);
		int _la;
		try {
			setState(49);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case EmptyContext:
				enterOuterAlt(_localctx, 1);
				{
				setState(35);
				match(EmptyContext);
				}
				break;
			case Identifier:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(36);
				match(Identifier);
				setState(37);
				match(T__4);
				setState(38);
				type(0);
				}
				setState(46);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(40);
					match(T__1);
					setState(41);
					match(Identifier);
					setState(42);
					match(T__4);
					setState(43);
					type(0);
					}
					}
					setState(48);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
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

	public static class TypeContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(SystemFParser.Identifier, 0); }
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public TerminalNode ForAll() { return getToken(SystemFParser.ForAll, 0); }
		public TerminalNode Arrow() { return getToken(SystemFParser.Arrow, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SystemFListener ) ((SystemFListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SystemFListener ) ((SystemFListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SystemFVisitor ) return ((SystemFVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		return type(0);
	}

	private TypeContext type(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		TypeContext _localctx = new TypeContext(_ctx, _parentState);
		TypeContext _prevctx = _localctx;
		int _startState = 8;
		enterRecursionRule(_localctx, 8, RULE_type, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(61);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Identifier:
				{
				setState(52);
				match(Identifier);
				}
				break;
			case T__0:
				{
				setState(53);
				match(T__0);
				setState(54);
				type(0);
				setState(55);
				match(T__2);
				}
				break;
			case ForAll:
				{
				setState(57);
				match(ForAll);
				setState(58);
				match(Identifier);
				setState(59);
				match(EmptyContext);
				setState(60);
				type(1);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(68);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new TypeContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_type);
					setState(63);
					if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
					setState(64);
					match(Arrow);
					setState(65);
					type(4);
					}
					} 
				}
				setState(70);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
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

	public static class TermContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(SystemFParser.Identifier, 0); }
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode Lambda() { return getToken(SystemFParser.Lambda, 0); }
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SystemFListener ) ((SystemFListener)listener).enterTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SystemFListener ) ((SystemFListener)listener).exitTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SystemFVisitor ) return ((SystemFVisitor<? extends T>)visitor).visitTerm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_term);
		try {
			setState(83);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(71);
				match(Identifier);
				}
				break;
			case T__0:
				enterOuterAlt(_localctx, 2);
				{
				setState(72);
				match(T__0);
				setState(73);
				term();
				setState(74);
				term();
				setState(75);
				match(T__2);
				setState(76);
				match(T__5);
				setState(77);
				type(0);
				setState(78);
				match(T__6);
				}
				break;
			case Lambda:
				enterOuterAlt(_localctx, 3);
				{
				setState(80);
				match(Lambda);
				setState(81);
				match(EmptyContext);
				setState(82);
				term();
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
		case 4:
			return type_sempred((TypeContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean type_sempred(TypeContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 3);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\25X\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\3\2\7\2\20\n\2\f\2\16\2\23\13\2\3\2"+
		"\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\7\5/\n\5\f\5\16\5\62\13\5\5\5\64\n\5\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6@\n\6\3\6\3\6\3\6\7\6E\n\6\f"+
		"\6\16\6H\13\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7V\n\7"+
		"\3\7\2\3\n\b\2\4\6\b\n\f\2\2\2Y\2\21\3\2\2\2\4\26\3\2\2\2\6\36\3\2\2\2"+
		"\b\63\3\2\2\2\n?\3\2\2\2\fU\3\2\2\2\16\20\5\4\3\2\17\16\3\2\2\2\20\23"+
		"\3\2\2\2\21\17\3\2\2\2\21\22\3\2\2\2\22\24\3\2\2\2\23\21\3\2\2\2\24\25"+
		"\5\6\4\2\25\3\3\2\2\2\26\27\7\n\2\2\27\30\7\3\2\2\30\31\7\20\2\2\31\32"+
		"\7\4\2\2\32\33\7\20\2\2\33\34\7\5\2\2\34\35\7\6\2\2\35\5\3\2\2\2\36\37"+
		"\5\b\5\2\37 \7\13\2\2 !\5\f\7\2!\"\7\7\2\2\"#\5\n\6\2#$\7\6\2\2$\7\3\2"+
		"\2\2%\64\7\f\2\2&\'\7\20\2\2\'(\7\7\2\2()\5\n\6\2)\60\3\2\2\2*+\7\4\2"+
		"\2+,\7\20\2\2,-\7\7\2\2-/\5\n\6\2.*\3\2\2\2/\62\3\2\2\2\60.\3\2\2\2\60"+
		"\61\3\2\2\2\61\64\3\2\2\2\62\60\3\2\2\2\63%\3\2\2\2\63&\3\2\2\2\64\t\3"+
		"\2\2\2\65\66\b\6\1\2\66@\7\20\2\2\678\7\3\2\289\5\n\6\29:\7\5\2\2:@\3"+
		"\2\2\2;<\7\r\2\2<=\7\20\2\2=>\7\f\2\2>@\5\n\6\3?\65\3\2\2\2?\67\3\2\2"+
		"\2?;\3\2\2\2@F\3\2\2\2AB\f\5\2\2BC\7\16\2\2CE\5\n\6\6DA\3\2\2\2EH\3\2"+
		"\2\2FD\3\2\2\2FG\3\2\2\2G\13\3\2\2\2HF\3\2\2\2IV\7\20\2\2JK\7\3\2\2KL"+
		"\5\f\7\2LM\5\f\7\2MN\7\5\2\2NO\7\b\2\2OP\5\n\6\2PQ\7\t\2\2QV\3\2\2\2R"+
		"S\7\17\2\2ST\7\f\2\2TV\5\f\7\2UI\3\2\2\2UJ\3\2\2\2UR\3\2\2\2V\r\3\2\2"+
		"\2\b\21\60\63?FU";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}