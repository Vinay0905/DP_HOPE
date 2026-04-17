INPUT:
    submissions = [code_1, code_2, ..., code_N]

OUTPUT:
    plagiarism_reports

--------------------------------------------------

# Step 1: Canonicalization
canonical_codes = [ ]

for code in submissions:
    ast = parse_to_AST(code)
    ast = normalize_AST(ast)
    ast = rename_identifiers(ast)
    canonical_codes.append(ast)

# Step 2: Fast Filtering (Levels 1–3)
hash_map = { }

for i, ast in enumerate(canonical_codes):
    h = hash(ast)
    if h in hash_map:
        mark_plagiarism(i, hash_map[h], level=1-3)
    else:
        hash_map[h] = i

# Step 3: Embedding (Levels 4–7+)
embeddings = [ ]

for ast in canonical_codes:
    emb = GraphCodeBERT.embed(ast)
    embeddings.append(emb)

# Step 4: Similarity Search / Clustering

clusters = cluster_embeddings(
    embeddings,
    similarity_threshold = 0.90
)

# Step 5: Analyze Clusters

for cluster in clusters:
    if cluster.size < 2:
        continue  # unique solution

    similarity_stats = compute_cluster_stats(cluster)

    # Step 6: Deep Analysis (Levels 8–12)
    for (code_i, code_j) in cluster.pairs:
        explanation = PLBART.explain(code_i, code_j)
        level = infer_plagiarism_level(code_i, code_j)

        record_result(
            code_i,
            code_j,
            similarity_stats,
            level,
            explanation
        )

# Step 7: Final Decision

generate_reports()
return plagiarism_reports
