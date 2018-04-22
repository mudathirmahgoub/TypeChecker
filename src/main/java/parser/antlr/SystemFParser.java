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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, SubBase=6, Turnstile=7, EmptyContext=8, 
		ForAll=9, Arrow=10, Lambda=11, Identifier=12, IdentifierLetter=13, Digit=14, 
		LineComment=15, WhiteSpace=16, AnyCharacter=17;
	public static final int
		RULE_systemF = 0, RULE_subtype = 1, RULE_judgment = 2, RULE_typingContext = 3, 
		RULE_type = 4, RULE_term = 5;
	public static final String[] ruleNames = {
		"systemF", "subtype", "judgment", "typingContext", "type", "term"
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
			term(0);
			setState(31);
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
			setState(47);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case EmptyContext:
				enterOuterAlt(_localctx, 1);
				{
				setState(33);
				match(EmptyContext);
				}
				break;
			case Identifier:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(34);
				match(Identifier);
				setState(35);
				match(T__4);
				setState(36);
				type(0);
				}
				setState(44);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(38);
					match(T__1);
					setState(39);
					match(Identifier);
					setState(40);
					match(T__4);
					setState(41);
					type(0);
					}
					}
					setState(46);
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
		public TerminalNode ForAll() { return getToken(SystemFParser.ForAll, 0); }
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
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
			setState(55);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Identifier:
				{
				setState(50);
				match(Identifier);
				}
				break;
			case ForAll:
				{
				setState(51);
				match(ForAll);
				setState(52);
				match(Identifier);
				setState(53);
				match(EmptyContext);
				setState(54);
				type(1);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(62);
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
					setState(57);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(58);
					match(Arrow);
					setState(59);
					type(3);
					}
					} 
				}
				setState(64);
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
		public TerminalNode Lambda() { return getToken(SystemFParser.Lambda, 0); }
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
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
		return term(0);
	}

	private TermContext term(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		TermContext _localctx = new TermContext(_ctx, _parentState);
		TermContext _prevctx = _localctx;
		int _startState = 10;
		enterRecursionRule(_localctx, 10, RULE_term, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(70);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Identifier:
				{
				setState(66);
				match(Identifier);
				}
				break;
			case Lambda:
				{
				setState(67);
				match(Lambda);
				setState(68);
				match(EmptyContext);
				setState(69);
				term(1);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(76);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new TermContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_term);
					setState(72);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(73);
					term(3);
					}
					} 
				}
				setState(78);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 4:
			return type_sempred((TypeContext)_localctx, predIndex);
		case 5:
			return term_sempred((TermContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean type_sempred(TypeContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean term_sempred(TermContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\23R\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\3\2\7\2\20\n\2\f\2\16\2\23\13\2\3\2"+
		"\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\7\5-\n\5\f\5\16\5\60\13\5\5\5\62\n\5\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\5\6:\n\6\3\6\3\6\3\6\7\6?\n\6\f\6\16\6B\13\6\3\7\3\7\3"+
		"\7\3\7\3\7\5\7I\n\7\3\7\3\7\7\7M\n\7\f\7\16\7P\13\7\3\7\2\4\n\f\b\2\4"+
		"\6\b\n\f\2\2\2R\2\21\3\2\2\2\4\26\3\2\2\2\6\36\3\2\2\2\b\61\3\2\2\2\n"+
		"9\3\2\2\2\fH\3\2\2\2\16\20\5\4\3\2\17\16\3\2\2\2\20\23\3\2\2\2\21\17\3"+
		"\2\2\2\21\22\3\2\2\2\22\24\3\2\2\2\23\21\3\2\2\2\24\25\5\6\4\2\25\3\3"+
		"\2\2\2\26\27\7\b\2\2\27\30\7\3\2\2\30\31\7\16\2\2\31\32\7\4\2\2\32\33"+
		"\7\16\2\2\33\34\7\5\2\2\34\35\7\6\2\2\35\5\3\2\2\2\36\37\5\b\5\2\37 \7"+
		"\t\2\2 !\5\f\7\2!\"\7\6\2\2\"\7\3\2\2\2#\62\7\n\2\2$%\7\16\2\2%&\7\7\2"+
		"\2&\'\5\n\6\2\'.\3\2\2\2()\7\4\2\2)*\7\16\2\2*+\7\7\2\2+-\5\n\6\2,(\3"+
		"\2\2\2-\60\3\2\2\2.,\3\2\2\2./\3\2\2\2/\62\3\2\2\2\60.\3\2\2\2\61#\3\2"+
		"\2\2\61$\3\2\2\2\62\t\3\2\2\2\63\64\b\6\1\2\64:\7\16\2\2\65\66\7\13\2"+
		"\2\66\67\7\16\2\2\678\7\n\2\28:\5\n\6\39\63\3\2\2\29\65\3\2\2\2:@\3\2"+
		"\2\2;<\f\4\2\2<=\7\f\2\2=?\5\n\6\5>;\3\2\2\2?B\3\2\2\2@>\3\2\2\2@A\3\2"+
		"\2\2A\13\3\2\2\2B@\3\2\2\2CD\b\7\1\2DI\7\16\2\2EF\7\r\2\2FG\7\n\2\2GI"+
		"\5\f\7\3HC\3\2\2\2HE\3\2\2\2IN\3\2\2\2JK\f\4\2\2KM\5\f\7\5LJ\3\2\2\2M"+
		"P\3\2\2\2NL\3\2\2\2NO\3\2\2\2O\r\3\2\2\2PN\3\2\2\2\t\21.\619@HN";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}