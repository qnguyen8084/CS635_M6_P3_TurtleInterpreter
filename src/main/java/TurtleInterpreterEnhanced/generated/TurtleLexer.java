// Generated from C:/Users/quy92/OneDrive/Documents/SDSU/2024Fall/CS635/CS635_M6_P3_TurtleInterpreter/src/main/java/org/example/Turtle.g4 by ANTLR 4.13.2
package TurtleInterpreterEnhanced.generated;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class TurtleLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, INT=8, WS=9, LINE_COMMENT=10;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "INT", "WS", 
			"LINE_COMMENT"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'turtle'", "'forward'", "'backward'", "'left'", "'right'", "'goto'", 
			"'setHeading'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, "INT", "WS", "LINE_COMMENT"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
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


	public TurtleLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Turtle.g4"; }

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
		"\u0004\u0000\n_\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0007\u0004\u0007J\b\u0007\u000b\u0007\f\u0007K\u0001\b\u0004"+
		"\bO\b\b\u000b\b\f\bP\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0005"+
		"\tY\b\t\n\t\f\t\\\t\t\u0001\t\u0001\t\u0000\u0000\n\u0001\u0001\u0003"+
		"\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011"+
		"\t\u0013\n\u0001\u0000\u0003\u0001\u000009\u0003\u0000\t\n\r\r  \u0002"+
		"\u0000\n\n\r\ra\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001"+
		"\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001"+
		"\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000"+
		"\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000"+
		"\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000\u0000"+
		"\u0000\u0001\u0015\u0001\u0000\u0000\u0000\u0003\u001c\u0001\u0000\u0000"+
		"\u0000\u0005$\u0001\u0000\u0000\u0000\u0007-\u0001\u0000\u0000\u0000\t"+
		"2\u0001\u0000\u0000\u0000\u000b8\u0001\u0000\u0000\u0000\r=\u0001\u0000"+
		"\u0000\u0000\u000fI\u0001\u0000\u0000\u0000\u0011N\u0001\u0000\u0000\u0000"+
		"\u0013T\u0001\u0000\u0000\u0000\u0015\u0016\u0005t\u0000\u0000\u0016\u0017"+
		"\u0005u\u0000\u0000\u0017\u0018\u0005r\u0000\u0000\u0018\u0019\u0005t"+
		"\u0000\u0000\u0019\u001a\u0005l\u0000\u0000\u001a\u001b\u0005e\u0000\u0000"+
		"\u001b\u0002\u0001\u0000\u0000\u0000\u001c\u001d\u0005f\u0000\u0000\u001d"+
		"\u001e\u0005o\u0000\u0000\u001e\u001f\u0005r\u0000\u0000\u001f \u0005"+
		"w\u0000\u0000 !\u0005a\u0000\u0000!\"\u0005r\u0000\u0000\"#\u0005d\u0000"+
		"\u0000#\u0004\u0001\u0000\u0000\u0000$%\u0005b\u0000\u0000%&\u0005a\u0000"+
		"\u0000&\'\u0005c\u0000\u0000\'(\u0005k\u0000\u0000()\u0005w\u0000\u0000"+
		")*\u0005a\u0000\u0000*+\u0005r\u0000\u0000+,\u0005d\u0000\u0000,\u0006"+
		"\u0001\u0000\u0000\u0000-.\u0005l\u0000\u0000./\u0005e\u0000\u0000/0\u0005"+
		"f\u0000\u000001\u0005t\u0000\u00001\b\u0001\u0000\u0000\u000023\u0005"+
		"r\u0000\u000034\u0005i\u0000\u000045\u0005g\u0000\u000056\u0005h\u0000"+
		"\u000067\u0005t\u0000\u00007\n\u0001\u0000\u0000\u000089\u0005g\u0000"+
		"\u00009:\u0005o\u0000\u0000:;\u0005t\u0000\u0000;<\u0005o\u0000\u0000"+
		"<\f\u0001\u0000\u0000\u0000=>\u0005s\u0000\u0000>?\u0005e\u0000\u0000"+
		"?@\u0005t\u0000\u0000@A\u0005H\u0000\u0000AB\u0005e\u0000\u0000BC\u0005"+
		"a\u0000\u0000CD\u0005d\u0000\u0000DE\u0005i\u0000\u0000EF\u0005n\u0000"+
		"\u0000FG\u0005g\u0000\u0000G\u000e\u0001\u0000\u0000\u0000HJ\u0007\u0000"+
		"\u0000\u0000IH\u0001\u0000\u0000\u0000JK\u0001\u0000\u0000\u0000KI\u0001"+
		"\u0000\u0000\u0000KL\u0001\u0000\u0000\u0000L\u0010\u0001\u0000\u0000"+
		"\u0000MO\u0007\u0001\u0000\u0000NM\u0001\u0000\u0000\u0000OP\u0001\u0000"+
		"\u0000\u0000PN\u0001\u0000\u0000\u0000PQ\u0001\u0000\u0000\u0000QR\u0001"+
		"\u0000\u0000\u0000RS\u0006\b\u0000\u0000S\u0012\u0001\u0000\u0000\u0000"+
		"TU\u0005/\u0000\u0000UV\u0005/\u0000\u0000VZ\u0001\u0000\u0000\u0000W"+
		"Y\b\u0002\u0000\u0000XW\u0001\u0000\u0000\u0000Y\\\u0001\u0000\u0000\u0000"+
		"ZX\u0001\u0000\u0000\u0000Z[\u0001\u0000\u0000\u0000[]\u0001\u0000\u0000"+
		"\u0000\\Z\u0001\u0000\u0000\u0000]^\u0006\t\u0000\u0000^\u0014\u0001\u0000"+
		"\u0000\u0000\u0004\u0000KPZ\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}