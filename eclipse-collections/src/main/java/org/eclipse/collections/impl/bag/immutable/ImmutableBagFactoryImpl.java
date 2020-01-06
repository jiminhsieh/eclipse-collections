/*
 * Copyright (c) 2016 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.impl.bag.immutable;

import org.eclipse.collections.api.bag.Bag;
import org.eclipse.collections.api.bag.ImmutableBag;
import org.eclipse.collections.api.bag.MutableBag;
import org.eclipse.collections.api.factory.bag.ImmutableBagFactory;
import org.eclipse.collections.api.tuple.primitive.ObjectIntPair;
import org.eclipse.collections.impl.bag.mutable.HashBag;
import org.eclipse.collections.impl.utility.Iterate;

public class ImmutableBagFactoryImpl implements ImmutableBagFactory
{
    public static final ImmutableBagFactory INSTANCE = new ImmutableBagFactoryImpl();

    @Override
    public <T> ImmutableBag<T> empty()
    {
        return (ImmutableBag<T>) ImmutableEmptyBag.INSTANCE;
    }

    @Override
    public <T> ImmutableBag<T> of()
    {
        return this.empty();
    }

    @Override
    public <T> ImmutableBag<T> with()
    {
        return this.empty();
    }

    @Override
    public <T> ImmutableBag<T> of(T element)
    {
        return this.with(element);
    }

    @Override
    public <T> ImmutableBag<T> with(T element)
    {
        return new ImmutableSingletonBag<>(element);
    }

    @Override
    public <T> ImmutableBag<T> of(T... elements)
    {
        return this.with(elements);
    }

    @Override
    public <T> ImmutableBag<T> with(T... elements)
    {
        if (elements == null || elements.length == 0)
        {
            return this.empty();
        }
        if (elements.length == 1)
        {
            return this.of(elements[0]);
        }
        if (elements.length < ImmutableArrayBag.MAXIMUM_USEFUL_ARRAY_BAG_SIZE)
        {
            return ImmutableArrayBag.newBagWith(elements);
        }
        return ImmutableHashBag.newBagWith(elements);
    }

    @Override
    public <T> ImmutableBag<T> ofAll(Iterable<? extends T> items)
    {
        return this.withAll(items);
    }

    @Override
    public <T> ImmutableBag<T> withAll(Iterable<? extends T> items)
    {
        if (items instanceof ImmutableBag<?>)
        {
            return (ImmutableBag<T>) items;
        }
        if (items instanceof Bag<?>)
        {
            Bag<T> bag = (Bag<T>) items;
            if (bag.isEmpty())
            {
                return this.with();
            }
            if (bag.size() == 1)
            {
                return this.with(bag.getFirst());
            }
            if (bag.sizeDistinct() < ImmutableArrayBag.MAXIMUM_USEFUL_ARRAY_BAG_SIZE)
            {
                return ImmutableArrayBag.copyFrom(bag);
            }
            return new ImmutableHashBag<>(bag);
        }
        return this.of((T[]) Iterate.toArray(items));
    }

    @Override
    public <T> ImmutableBag<T> withOccurrences(T element, int occurrence)
    {
        MutableBag<T> bag = new HashBag<>(occurrence);
        bag.addOccurrences(element, occurrence);

        return bag.toImmutable();
    }

    @Override
    public <T> ImmutableBag<T> withOccurrences(T element1, int occurrence1, T element2, int occurrence2)
    {
        MutableBag<T> bag = new HashBag<>(occurrence1 + occurrence2);
        bag.addOccurrences(element1, occurrence1);
        bag.addOccurrences(element2, occurrence2);
        return bag.toImmutable();
    }

    @Override
    public <T> ImmutableBag<T> withOccurrences(T element1, int occurrence1, T element2, int occurrence2, T element3, int occurrence3)
    {
        MutableBag<T> bag = new HashBag<>(occurrence1 + occurrence2 + occurrence3);
        bag.addOccurrences(element1, occurrence1);
        bag.addOccurrences(element2, occurrence2);
        bag.addOccurrences(element3, occurrence3);
        return bag.toImmutable();
    }

    @Override
    public <T> ImmutableBag<T> withOccurrences(T element1, int occurrence1, T element2, int occurrence2, T element3, int occurrence3, T element4, int occurrence4)
    {
        MutableBag<T> bag = new HashBag<>(occurrence1 + occurrence2 + occurrence3 + occurrence4);
        bag.addOccurrences(element1, occurrence1);
        bag.addOccurrences(element2, occurrence2);
        bag.addOccurrences(element3, occurrence3);
        bag.addOccurrences(element4, occurrence4);
        return bag.toImmutable();
    }

    @Override
    public <T> ImmutableBag<T> withOccurrences(ObjectIntPair<T>... elementsWithOccurrences)
    {
        MutableBag<T> bag = new HashBag<>();
        for (int i = 0; i < elementsWithOccurrences.length; i++)
        {
            ObjectIntPair<T> itemToAdd = elementsWithOccurrences[i];
            bag.addOccurrences(itemToAdd.getOne(), itemToAdd.getTwo());
        }
        return bag.toImmutable();
    }
}
