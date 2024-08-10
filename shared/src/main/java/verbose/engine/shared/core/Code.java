package verbose.engine.shared.core;

import lombok.Getter;

@Getter
public enum Code {
    ERR_UNKNOWN(-1);
    private final Integer code;
    Code(Integer code) {
        this.code = code;
    }
}
