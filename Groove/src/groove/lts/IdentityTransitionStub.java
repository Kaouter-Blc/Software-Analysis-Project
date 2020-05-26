// GROOVE: GRaphs for Object Oriented VErification
// Copyright 2003--2007 University of Twente

// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
// http://www.apache.org/licenses/LICENSE-2.0

// Unless required by applicable law or agreed to in writing,
// software distributed under the License is distributed on an
// "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
// either express or implied. See the License for the specific
// language governing permissions and limitations under the License.
/*
 * $Id: IdentityTransitionStub.java 5479 2014-07-19 12:20:13Z rensink $
 */
package groove.lts;

import groove.grammar.host.HostNode;

/**
 * Graph transition stub based on an identity morphism.
 * @author Arend Rensink
 * @version $Revision: 5479 $
 */
class IdentityTransitionStub extends AbstractRuleTransitionStub {
    /**
     * Default constructor, providing the event and target of the stub.
     */
    IdentityTransitionStub(MatchResult match, HostNode[] addedNodes, GraphState target) {
        super(match, addedNodes, target);
    }

    /** This type of transition stub involves no non-trivial symmetry. */
    @Override
    public boolean isSymmetry() {
        return false;
    }
}
