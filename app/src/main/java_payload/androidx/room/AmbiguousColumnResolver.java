/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.collections.IntIterator
 *  kotlin.collections.SetsKt
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function3
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Ref$ObjectRef
 *  kotlin.ranges.IntRange
 */
package androidx.room;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.IntRange;

@Metadata(d1={"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0007\b\u00c7\u0002\u0018\u00002\u00020\u0001:\u0003\u001b\u001c\u001dB\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002JV\u0010\u0003\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00052\u0012\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\u00070\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00050\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u0018\u0010\f\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\u0007\u0012\u0004\u0012\u00020\u00040\rH\u0002JO\u0010\u000e\u001a\u00020\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00072\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112$\u0010\u0013\u001a \u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u0007\u0012\u0004\u0012\u00020\u00040\u0014H\u0002\u00a2\u0006\u0002\u0010\u0015J5\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u00112\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0012\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u0011H\u0007\u00a2\u0006\u0002\u0010\u001a\u00a8\u0006\u001e"}, d2={"Landroidx/room/AmbiguousColumnResolver;", "", "()V", "dfs", "", "T", "content", "", "current", "", "depth", "", "block", "Lkotlin/Function1;", "rabinKarpSearch", "Landroidx/room/AmbiguousColumnResolver$ResultColumn;", "pattern", "", "", "onHashMatch", "Lkotlin/Function3;", "(Ljava/util/List;[Ljava/lang/String;Lkotlin/jvm/functions/Function3;)V", "resolve", "", "resultColumns", "mappings", "([Ljava/lang/String;[[Ljava/lang/String;)[[I", "Match", "ResultColumn", "Solution", "room-common"}, k=1, mv={1, 7, 1}, xi=48)
public final class AmbiguousColumnResolver {
    public static final AmbiguousColumnResolver INSTANCE = new AmbiguousColumnResolver();

    private AmbiguousColumnResolver() {
    }

    private final <T> void dfs(List<? extends List<? extends T>> list, List<T> list2, int n, Function1<? super List<? extends T>, Unit> function1) {
        if (n == list.size()) {
            function1.invoke((Object)CollectionsKt.toList((Iterable)list2));
            return;
        }
        Iterator iterator2 = ((Iterable)list.get(n)).iterator();
        while (iterator2.hasNext()) {
            list2.add(iterator2.next());
            INSTANCE.dfs(list, list2, n + 1, function1);
            CollectionsKt.removeLast(list2);
        }
    }

    static /* synthetic */ void dfs$default(AmbiguousColumnResolver ambiguousColumnResolver, List list, List list2, int n, Function1 function1, int n2, Object object) {
        if ((n2 & 2) != 0) {
            list2 = new ArrayList();
        }
        if ((n2 & 4) != 0) {
            n = 0;
        }
        ambiguousColumnResolver.dfs(list, list2, n, function1);
    }

    private final void rabinKarpSearch(List<ResultColumn> list, String[] object, Function3<? super Integer, ? super Integer, ? super List<ResultColumn>, Unit> function3) {
        int n;
        Object object2;
        int n2;
        int n3 = ((String[])object).length;
        int n4 = 0;
        int n5 = 0;
        for (n2 = 0; n2 < n3; ++n2) {
            object2 = object[n2];
            n5 += ((String)object2).hashCode();
        }
        int n6 = 0;
        int n7 = ((String[])object).length;
        object2 = ((Iterable)list.subList(0, n7)).iterator();
        n2 = n4;
        while (true) {
            n4 = n2;
            n = n6;
            n3 = n7;
            if (!object2.hasNext()) break;
            object = (ResultColumn)object2.next();
            n2 += ((ResultColumn)object).getName().hashCode();
        }
        while (true) {
            if (n5 == n4) {
                function3.invoke((Object)n, (Object)n3, list.subList(n, n3));
            }
            ++n;
            if (++n3 > list.size()) {
                return;
            }
            n4 = n4 - list.get(n - 1).getName().hashCode() + list.get(n3 - 1).getName().hashCode();
        }
    }

    @JvmStatic
    public static final int[][] resolve(String[] object, String[][] object2) {
        List list;
        int n;
        block18: {
            Object object3;
            int n2;
            Object object4;
            Object object5;
            Intrinsics.checkNotNullParameter((Object)object, (String)"resultColumns");
            Intrinsics.checkNotNullParameter((Object)object2, (String)"mappings");
            int n3 = ((String[])object).length;
            for (n = 0; n < n3; ++n) {
                object5 = object[n];
                if (((String)object5).charAt(0) == '`' && ((String)object5).charAt(((String)object5).length() - 1) == '`') {
                    object5 = ((String)object5).substring(1, ((String)object5).length() - 1);
                    Intrinsics.checkNotNullExpressionValue((Object)object5, (String)"this as java.lang.String\u2026ing(startIndex, endIndex)");
                }
                object4 = Locale.US;
                Intrinsics.checkNotNullExpressionValue((Object)object4, (String)"US");
                object5 = ((String)object5).toLowerCase((Locale)object4);
                Intrinsics.checkNotNullExpressionValue((Object)object5, (String)"this as java.lang.String).toLowerCase(locale)");
                object[n] = object5;
            }
            int n4 = ((Object[])object2).length;
            for (n = 0; n < n4; ++n) {
                n2 = object2[n].length;
                for (n3 = 0; n3 < n2; ++n3) {
                    object5 = object2[n];
                    object4 = object2[n][n3];
                    object3 = Locale.US;
                    Intrinsics.checkNotNullExpressionValue((Object)object3, (String)"US");
                    object4 = ((String)object4).toLowerCase((Locale)object3);
                    Intrinsics.checkNotNullExpressionValue((Object)object4, (String)"this as java.lang.String).toLowerCase(locale)");
                    object5[n3] = object4;
                }
            }
            object5 = SetsKt.createSetBuilder();
            object3 = (Object[])object2;
            n3 = ((Object[])object3).length;
            for (n = 0; n < n3; ++n) {
                object4 = (String[])object3[n];
                CollectionsKt.addAll((Collection)((Collection)object5), (Object[])object4);
            }
            object3 = SetsKt.build((Set)object5);
            object4 = CollectionsKt.createListBuilder();
            n = 0;
            n4 = ((String[])object).length;
            n3 = 0;
            while (n3 < n4) {
                object5 = object[n3];
                if (object3.contains(object5)) {
                    object4.add(new ResultColumn((String)object5, n));
                }
                ++n3;
                ++n;
            }
            object = CollectionsKt.build((List)object4);
            n3 = ((Object[])object2).length;
            object5 = new ArrayList(n3);
            for (n = 0; n < n3; ++n) {
                ((ArrayList)object5).add((List)new ArrayList());
            }
            list = (List)object5;
            object4 = (Object[])object2;
            n3 = 0;
            int n5 = ((Object)object4).length;
            n4 = 0;
            while (n4 < n5) {
                object5 = (String[])object4[n4];
                object2 = INSTANCE;
                super.rabinKarpSearch((List<ResultColumn>)object, (String[])object5, (Function3<? super Integer, ? super Integer, ? super List<ResultColumn>, Unit>)((Function3)new Function3<Integer, Integer, List<? extends ResultColumn>, Unit>((String[])object5, (List<? extends List<Match>>)list, n3){
                    final String[] $mapping;
                    final int $mappingIndex;
                    final List<List<Match>> $mappingMatches;
                    {
                        this.$mapping = stringArray;
                        this.$mappingMatches = list;
                        this.$mappingIndex = n;
                        super(3);
                    }

                    public final void invoke(int n, int n2, List<ResultColumn> list) {
                        Object object2;
                        Intrinsics.checkNotNullParameter(list, (String)"resultColumnsSublist");
                        IntRange intRange = this.$mapping;
                        Collection collection = new ArrayList<E>(((String[])intRange).length);
                        for (String string2 : intRange) {
                            block3: {
                                for (Object object2 : (Iterable)list) {
                                    if (!Intrinsics.areEqual((Object)string2, (Object)((ResultColumn)object2).component1())) continue;
                                    break block3;
                                }
                                object2 = null;
                            }
                            object2 = (ResultColumn)object2;
                            if (object2 != null) {
                                collection.add(((ResultColumn)object2).getIndex());
                                continue;
                            }
                            return;
                        }
                        object2 = (List)collection;
                        list = this.$mappingMatches.get(this.$mappingIndex);
                        intRange = new IntRange(n, n2 - 1);
                        list.add((ResultColumn)((Object)new Match(intRange, (List<Integer>)object2)));
                    }
                }));
                if (((List)list.get(n3)).isEmpty()) {
                    Collection collection = new ArrayList(((Object)object5).length);
                    n = ((Object)object5).length;
                    for (n2 = 0; n2 < n; ++n2) {
                        List list2;
                        Object object6 = object5[n2];
                        List list3 = list2 = CollectionsKt.createListBuilder();
                        Iterator iterator2 = ((Iterable)object).iterator();
                        object2 = object;
                        object = object5;
                        while (iterator2.hasNext()) {
                            object5 = (ResultColumn)iterator2.next();
                            if (!Intrinsics.areEqual((Object)object6, (Object)((ResultColumn)object5).getName())) continue;
                            list3.add(((ResultColumn)object5).getIndex());
                        }
                        object5 = CollectionsKt.build((List)list2);
                        if (((Collection)object5).isEmpty() ^ true) {
                            collection.add(object5);
                            object5 = object;
                            object = object2;
                            continue;
                        }
                        throw new IllegalStateException(("Column " + (String)object6 + " not found in result").toString());
                    }
                    object2 = (List)collection;
                    AmbiguousColumnResolver.dfs$default(INSTANCE, (List)object2, null, 0, (Function1)new Function1<List<? extends Integer>, Unit>((List<? extends List<Match>>)list, n3){
                        final int $mappingIndex;
                        final List<List<Match>> $mappingMatches;
                        {
                            this.$mappingMatches = list;
                            this.$mappingIndex = n;
                            super(1);
                        }

                        public final void invoke(List<Integer> list) {
                            Intrinsics.checkNotNullParameter(list, (String)"indices");
                            Iterator<T> iterator2 = ((Iterable)list).iterator();
                            if (iterator2.hasNext()) {
                                int n;
                                int n2 = ((Number)iterator2.next()).intValue();
                                while (iterator2.hasNext()) {
                                    n = ((Number)iterator2.next()).intValue();
                                    if (n2 <= n) continue;
                                    n2 = n;
                                }
                                iterator2 = ((Iterable)list).iterator();
                                if (iterator2.hasNext()) {
                                    n = ((Number)iterator2.next()).intValue();
                                    while (iterator2.hasNext()) {
                                        int n3 = ((Number)iterator2.next()).intValue();
                                        if (n >= n3) continue;
                                        n = n3;
                                    }
                                    iterator2 = this.$mappingMatches.get(this.$mappingIndex);
                                    IntRange intRange = new IntRange(n2, n);
                                    iterator2.add(new Match(intRange, list));
                                    return;
                                }
                                throw new NoSuchElementException();
                            }
                            throw new NoSuchElementException();
                        }
                    }, 6, null);
                }
                ++n4;
                ++n3;
            }
            object = list;
            if (object instanceof Collection && ((Collection)object).isEmpty()) {
                n = 1;
            } else {
                object = object.iterator();
                while (object.hasNext()) {
                    if (((Collection)((List)object.next())).isEmpty() ^ true) continue;
                    n = 0;
                    break block18;
                }
                n = 1;
            }
        }
        if (n != 0) {
            object = new Ref.ObjectRef();
            ((Ref.ObjectRef)object).element = Solution.Companion.getNO_SOLUTION();
            AmbiguousColumnResolver.dfs$default(INSTANCE, list, null, 0, (Function1)new Function1<List<? extends Match>, Unit>((Ref.ObjectRef<Solution>)object){
                final Ref.ObjectRef<Solution> $bestSolution;
                {
                    this.$bestSolution = objectRef;
                    super(1);
                }

                public final void invoke(List<Match> object) {
                    Intrinsics.checkNotNullParameter(object, (String)"it");
                    object = Solution.Companion.build((List<Match>)object);
                    if (((Solution)object).compareTo((Solution)this.$bestSolution.element) < 0) {
                        this.$bestSolution.element = object;
                    }
                }
            }, 6, null);
            object2 = ((Solution)((Ref.ObjectRef)object).element).getMatches();
            object = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)object2, (int)10));
            object2 = object2.iterator();
            while (object2.hasNext()) {
                object.add(CollectionsKt.toIntArray((Collection)((Match)object2.next()).getResultIndices()));
            }
            object = (List)object;
            object = (Collection)object;
            object = object.toArray((T[])new int[0][]);
            Intrinsics.checkNotNull((Object)object, (String)"null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            return (int[][])object;
        }
        throw new IllegalStateException("Failed to find matches for all mappings".toString());
    }

    @Metadata(d1={"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\u0002\u0010\u0007R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2={"Landroidx/room/AmbiguousColumnResolver$Match;", "", "resultRange", "Lkotlin/ranges/IntRange;", "resultIndices", "", "", "(Lkotlin/ranges/IntRange;Ljava/util/List;)V", "getResultIndices", "()Ljava/util/List;", "getResultRange", "()Lkotlin/ranges/IntRange;", "room-common"}, k=1, mv={1, 7, 1}, xi=48)
    private static final class Match {
        private final List<Integer> resultIndices;
        private final IntRange resultRange;

        public Match(IntRange intRange, List<Integer> list) {
            Intrinsics.checkNotNullParameter((Object)intRange, (String)"resultRange");
            Intrinsics.checkNotNullParameter(list, (String)"resultIndices");
            this.resultRange = intRange;
            this.resultIndices = list;
        }

        public final List<Integer> getResultIndices() {
            return this.resultIndices;
        }

        public final IntRange getResultRange() {
            return this.resultRange;
        }
    }

    @Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0082\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0011\u001a\u00020\u0005H\u00d6\u0001J\t\u0010\u0012\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0013"}, d2={"Landroidx/room/AmbiguousColumnResolver$ResultColumn;", "", "name", "", "index", "", "(Ljava/lang/String;I)V", "getIndex", "()I", "getName", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "room-common"}, k=1, mv={1, 7, 1}, xi=48)
    private static final class ResultColumn {
        private final int index;
        private final String name;

        public ResultColumn(String string2, int n) {
            Intrinsics.checkNotNullParameter((Object)string2, (String)"name");
            this.name = string2;
            this.index = n;
        }

        public static /* synthetic */ ResultColumn copy$default(ResultColumn resultColumn, String string2, int n, int n2, Object object) {
            if ((n2 & 1) != 0) {
                string2 = resultColumn.name;
            }
            if ((n2 & 2) != 0) {
                n = resultColumn.index;
            }
            return resultColumn.copy(string2, n);
        }

        public final String component1() {
            return this.name;
        }

        public final int component2() {
            return this.index;
        }

        public final ResultColumn copy(String string2, int n) {
            Intrinsics.checkNotNullParameter((Object)string2, (String)"name");
            return new ResultColumn(string2, n);
        }

        public boolean equals(Object object) {
            if (this == object) {
                return true;
            }
            if (!(object instanceof ResultColumn)) {
                return false;
            }
            object = (ResultColumn)object;
            if (!Intrinsics.areEqual((Object)this.name, (Object)((ResultColumn)object).name)) {
                return false;
            }
            return this.index == ((ResultColumn)object).index;
        }

        public final int getIndex() {
            return this.index;
        }

        public final String getName() {
            return this.name;
        }

        public int hashCode() {
            return this.name.hashCode() * 31 + Integer.hashCode(this.index);
        }

        public String toString() {
            return "ResultColumn(name=" + this.name + ", index=" + this.index + ')';
        }
    }

    @Metadata(d1={"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0002\u0018\u0000 \u00102\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0010B#\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\bJ\u0011\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0000H\u0096\u0002R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n\u00a8\u0006\u0011"}, d2={"Landroidx/room/AmbiguousColumnResolver$Solution;", "", "matches", "", "Landroidx/room/AmbiguousColumnResolver$Match;", "coverageOffset", "", "overlaps", "(Ljava/util/List;II)V", "getCoverageOffset", "()I", "getMatches", "()Ljava/util/List;", "getOverlaps", "compareTo", "other", "Companion", "room-common"}, k=1, mv={1, 7, 1}, xi=48)
    private static final class Solution
    implements Comparable<Solution> {
        public static final Companion Companion = new Companion(null);
        private static final Solution NO_SOLUTION = new Solution(CollectionsKt.emptyList(), Integer.MAX_VALUE, Integer.MAX_VALUE);
        private final int coverageOffset;
        private final List<Match> matches;
        private final int overlaps;

        public Solution(List<Match> list, int n, int n2) {
            Intrinsics.checkNotNullParameter(list, (String)"matches");
            this.matches = list;
            this.coverageOffset = n;
            this.overlaps = n2;
        }

        @Override
        public int compareTo(Solution solution) {
            Intrinsics.checkNotNullParameter((Object)solution, (String)"other");
            int n = Intrinsics.compare((int)this.overlaps, (int)solution.overlaps);
            if (n != 0) {
                return n;
            }
            return Intrinsics.compare((int)this.coverageOffset, (int)solution.coverageOffset);
        }

        public final int getCoverageOffset() {
            return this.coverageOffset;
        }

        public final List<Match> getMatches() {
            return this.matches;
        }

        public final int getOverlaps() {
            return this.overlaps;
        }

        @Metadata(d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0014\u0010\u0007\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tR\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u000b"}, d2={"Landroidx/room/AmbiguousColumnResolver$Solution$Companion;", "", "()V", "NO_SOLUTION", "Landroidx/room/AmbiguousColumnResolver$Solution;", "getNO_SOLUTION", "()Landroidx/room/AmbiguousColumnResolver$Solution;", "build", "matches", "", "Landroidx/room/AmbiguousColumnResolver$Match;", "room-common"}, k=1, mv={1, 7, 1}, xi=48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final Solution build(List<Match> list) {
                Object object;
                Intrinsics.checkNotNullParameter(list, (String)"matches");
                Iterator iterator2 = ((Iterable)list).iterator();
                int n = 0;
                while (iterator2.hasNext()) {
                    object = (Match)iterator2.next();
                    n += ((Match)object).getResultRange().getLast() - ((Match)object).getResultRange().getFirst() + 1 - ((Match)object).getResultIndices().size();
                }
                object = ((Iterable)list).iterator();
                if (object.hasNext()) {
                    int n2;
                    int n3 = ((Match)object.next()).getResultRange().getFirst();
                    while (object.hasNext()) {
                        n2 = ((Match)object.next()).getResultRange().getFirst();
                        if (n3 <= n2) continue;
                        n3 = n2;
                    }
                    object = ((Iterable)list).iterator();
                    if (object.hasNext()) {
                        int n4;
                        n2 = ((Match)object.next()).getResultRange().getLast();
                        while (object.hasNext()) {
                            n4 = ((Match)object.next()).getResultRange().getLast();
                            if (n2 >= n4) continue;
                            n2 = n4;
                        }
                        object = (Iterable)new IntRange(n3, n2);
                        if (object instanceof Collection && ((Collection)object).isEmpty()) {
                            n3 = 0;
                        } else {
                            n3 = 0;
                            iterator2 = object.iterator();
                            while (iterator2.hasNext()) {
                                block11: {
                                    int n5 = ((IntIterator)iterator2).nextInt();
                                    n2 = 0;
                                    object = ((Iterable)list).iterator();
                                    while (object.hasNext()) {
                                        n4 = n2;
                                        if (((Match)object.next()).getResultRange().contains(n5)) {
                                            n4 = n2 + 1;
                                        }
                                        if (n4 > 1) {
                                            n2 = 1;
                                            break block11;
                                        }
                                        n2 = n4;
                                    }
                                    n2 = 0;
                                }
                                if (n2 == 0) continue;
                                n3 = n2 = n3 + 1;
                                if (n2 >= 0) continue;
                                CollectionsKt.throwCountOverflow();
                                n3 = n2;
                            }
                        }
                        return new Solution(list, n, n3);
                    }
                    throw new NoSuchElementException();
                }
                throw new NoSuchElementException();
            }

            public final Solution getNO_SOLUTION() {
                return NO_SOLUTION;
            }
        }
    }
}

