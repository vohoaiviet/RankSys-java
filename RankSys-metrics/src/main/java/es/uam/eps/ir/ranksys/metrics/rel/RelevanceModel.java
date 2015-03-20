/* 
 * Copyright (C) 2015 Information Retrieval Group at Universidad Autonoma
 * de Madrid, http://ir.ii.uam.es
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package es.uam.eps.ir.ranksys.metrics.rel;

import es.uam.eps.ir.ranksys.core.model.UserModel;
import java.util.stream.Stream;

/**
 *
 * @author Saúl Vargas (saul.vargas@uam.es)
 * @author Pablo Castells (pablo.castells@uam.es)
 */
public abstract class RelevanceModel<U, I> extends UserModel<U> {

    public RelevanceModel(boolean caching, Stream<U> users) {
        super(caching, users);
    }

    public RelevanceModel() {
        super();
    }

    public RelevanceModel(Stream<U> users) {
        super(users);
    }

    @Override
    protected abstract UserRelevanceModel<U, I> get(U user);

    @SuppressWarnings("unchecked")
    @Override
    public UserRelevanceModel<U, I> getModel(U user) {
        return (UserRelevanceModel<U, I>) super.getModel(user);
    }

    public interface UserRelevanceModel<U, I> extends Model<U> {

        public boolean isRelevant(I item);

        public double gain(I item);
    }
}
