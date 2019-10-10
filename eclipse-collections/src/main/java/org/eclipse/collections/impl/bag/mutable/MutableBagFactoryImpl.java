/*
 * Copyright (c) 2019 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.impl.bag.mutable;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.collections.api.bag.MutableBag;
import org.eclipse.collections.api.factory.bag.MutableBagFactory;
import org.eclipse.collections.api.tuple.primitive.IntIntPair;
import org.eclipse.collections.api.tuple.primitive.ObjectIntPair;

public class MutableBagFactoryImpl implements MutableBagFactory
{
    public static final MutableBagFactory INSTANCE = new MutableBagFactoryImpl();

    @Override
    public <T> MutableBag<T> empty()
    {
        return HashBag.newBag();
    }

    @Override
    public <T> MutableBag<T> with(T... elements)
    {
        return HashBag.newBagWith(elements);
    }

    @Override
    public <T> MutableBag<T> withAll(Iterable<? extends T> items)
    {
        return HashBag.newBag(items);
    }

    @Override
    public <T> MutableBag<T> fromStream(Stream<? extends T> stream)
    {
        return stream.collect(Collectors.toCollection(HashBag::newBag));
    }

    @Override
    public <T> MutableBag<T> withOccurrences(T element, int occurrence)
    {
        MutableBag<T> bag = new HashBag<>(occurrence);
        bag.addOccurrences(element, occurrence);
        return bag;
    }

    @Override
    public <T> MutableBag<T> withOccurrences(T element1, int occurrence1, T element2, int occurrence2)
    {
        MutableBag<T> bag = new HashBag<>(occurrence1 + occurrence2);
        bag.addOccurrences(element1, occurrence1);
        bag.addOccurrences(element2, occurrence2);
        return bag;
    }

    @Override
    public <T> MutableBag<T> withOccurrences(T element1, int occurrence1, T element2, int occurrence2, T element3, int occurrence3)
    {
        MutableBag<T> bag = new HashBag<>(occurrence1 + occurrence2 + occurrence3);
        bag.addOccurrences(element1, occurrence1);
        bag.addOccurrences(element2, occurrence2);
        bag.addOccurrences(element3, occurrence3);
        return bag;
    }

    @Override
    public <T> MutableBag<T> withOccurrences(T element1, int occurrence1, T element2, int occurrence2, T element3, int occurrence3, T element4, int occurrence4)
    {
        MutableBag<T> bag = new HashBag<>(occurrence1 + occurrence2 + occurrence3 + occurrence4);
        bag.addOccurrences(element1, occurrence1);
        bag.addOccurrences(element2, occurrence2);
        bag.addOccurrences(element3, occurrence3);
        bag.addOccurrences(element4, occurrence4);
        return bag;
    }

    @Override
    public <T> MutableBag<T> withOccurrences(ObjectIntPair<T>... elementsWithOccurrences)
    {
        MutableBag<T> bag = new HashBag<>();
        for (int i = 0; i < elementsWithOccurrences.length; i++)
        {
            ObjectIntPair<T> itemToAdd = elementsWithOccurrences[i];
            bag.addOccurrences(itemToAdd.getOne(), itemToAdd.getTwo());
        }
        return bag;
    }

    @Override
    public MutableBag<Integer>  withOccurrences(IntIntPair... elementsWithOccurrences)
    {
        if (elementsWithOccurrences == null || elementsWithOccurrences.length == 0)
        {
            return this.empty();
        }
        if (elementsWithOccurrences.length == 1)
        {
            return this.withOccurrences(elementsWithOccurrences[0].getOne(), elementsWithOccurrences[0].getTwo());
        }
        if (elementsWithOccurrences.length == 2)
        {
            return this.withOccurrences(
                    elementsWithOccurrences[0].getOne(), elementsWithOccurrences[0].getTwo(),
                    elementsWithOccurrences[1].getOne(), elementsWithOccurrences[1].getTwo());
        }
        if (elementsWithOccurrences.length == 3)
        {
            return this.withOccurrences(
                    elementsWithOccurrences[0].getOne(), elementsWithOccurrences[0].getTwo(),
                    elementsWithOccurrences[1].getOne(), elementsWithOccurrences[1].getTwo(),
                    elementsWithOccurrences[2].getOne(), elementsWithOccurrences[2].getTwo());
        }
        if (elementsWithOccurrences.length == 4)
        {
            return this.withOccurrences(
                    elementsWithOccurrences[0].getOne(), elementsWithOccurrences[0].getTwo(),
                    elementsWithOccurrences[1].getOne(), elementsWithOccurrences[1].getTwo(),
                    elementsWithOccurrences[2].getOne(), elementsWithOccurrences[2].getTwo(),
                    elementsWithOccurrences[3].getOne(), elementsWithOccurrences[3].getTwo());
        }

        MutableBag<Integer> bag = new HashBag<>();
        for (int i = 0; i < elementsWithOccurrences.length; i++)
        {
            IntIntPair itemToAdd = elementsWithOccurrences[i];
            bag.addOccurrences(itemToAdd.getOne(), itemToAdd.getTwo());
        }
        return bag;
    }
}
