package verbose.engine.shared.meta;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import verbose.engine.shared.core.Code;

@Setter
@Getter
@AllArgsConstructor
public class Error {
    private Code code;
    private String message;
    private String details;
}
