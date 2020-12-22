package com.github.easytag.core.dto.express;

import java.io.Serializable;
import java.util.List;

public class ExpressCondition implements Serializable {
    private List<ExpressBranch> expressBranches;

    public List<ExpressBranch> getExpressBranches() {
        return expressBranches;
    }

    public void setExpressBranches(List<ExpressBranch> expressBranches) {
        this.expressBranches = expressBranches;
    }
}
