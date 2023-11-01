package stratego;
/**
 * An enum classes that is called to decide the outcome when a given piece attacks another targetPiece.
 */
public enum CombatResult {
    /** WIN - When the given piece successfully defeats the targetPiece afeter attacking. */
    WIN,
    /** DRAW - When the given piece attacks a targetPiece and both the given piece and TargetPiece gets destroyed. */
    DRAW,
    /** LOSE - When the given piece is destroyed when it attacks a targetPiece. */
    LOSE
}
